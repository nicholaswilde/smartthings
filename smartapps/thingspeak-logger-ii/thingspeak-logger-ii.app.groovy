/**
 *  ThingSpeak Logger II
 *
 *  Based on "ThingSpeak Logger by florianz
 *
 *  Author: Nicholas Wilde
 *  Date: 2014-07-08
 *
 *	Changes from florianz's ThingSpeakLogger:
 *		- Added illuminance & relative humidity sensors
 *		- Convert device names and map values to lowercase before looking for field number.
 *
 *  Create a ThingSpeak channel with a write key. The app must be given the channel id and key.
 *  Then, create a field for each device and name the field according to the label given to the
 *  device in SmartThings.
 *
 */

// Automatically generated. Make future change here.
definition(
    name: "ThingSpeak Logger II",
    namespace: "nicholaswilde/smartthings",
    author: "Nicholas Wilde",
    description: "Log events to ThingSpeak",
    category: "Convenience",
    iconUrl: "https://lh6.googleusercontent.com/-LCt2nG3Npbo/AAAAAAAAAAI/AAAAAAAAAB8/O6sWrun4q6w/s50-c/photo.jpg",
    iconX2Url: "https://lh6.googleusercontent.com/-LCt2nG3Npbo/AAAAAAAAAAI/AAAAAAAAAB8/O6sWrun4q6w/s100-c/photo.jpg")

preferences {
    section("Log devices...") {
    	input "illuminants", "capability.illuminanceMeasurement", title: "Illuminants", required:false, multiple: true
        input "humidities", "capability.relativeHumidityMeasurement", title: "Relative Humidities", required:false, multiple: true
        input "temperatures", "capability.temperatureMeasurement", title: "Temperatures", required:false, multiple: true        
        input "contacts", "capability.contactSensor", title: "Contacts", required: false, multiple: true
        input "accelerations", "capability.accelerationSensor", title: "Accelerations", required: false, multiple: true
        input "motions", "capability.motionSensor", title: "Motions", required: false, multiple: true
        input "switches", "capability.switch", title: "Switches", required: false, multiple: true
    }

    section ("ThinkSpeak channel id...") {
        input "channelId", "number", title: "Channel ID"
    }

    section ("ThinkSpeak write key...") {
        input "channelKey", "password", title: "Channel Key"
    }
}

def installed() {
    initialize()
}

def updated() {
    unsubscribe()
    initialize()
}

def initialize() {
	subscribe(illuminants, "illuminance", handleIlluminanceEvent)
	subscribe(humidities, "humidity", handleHumidityEvent)
    subscribe(temperatures, "temperature", handleTemperatureEvent)
    subscribe(contacts, "contact", handleContactEvent)
    subscribe(accelerations, "acceleration", handleAccelerationEvent)
    subscribe(motions, "motion", handleMotionEvent)
    subscribe(switches, "switch", handleSwitchEvent)

    updateChannelInfo()
    log.debug state.fieldMap
}

def handleIlluminanceEvent(evt) {
    logField(evt) { it.toString() }
}

def handleHumidityEvent(evt) {
    logField(evt) { it.toString() }
}

def handleTemperatureEvent(evt) {
    logField(evt) { it.toString() }
}

def handleContactEvent(evt) {
    logField(evt) { it == "open" ? "1" : "0" }
}

def handleAccelerationEvent(evt) {
    logField(evt) { it == "active" ? "1" : "0" }
}

def handleMotionEvent(evt) {
    logField(evt) { it == "active" ? "1" : "0" }
}

def handleSwitchEvent(evt) {
    logField(evt) { it == "on" ? "1" : "0" }
}

private getFieldMap(channelInfo) {
    def fieldMap = [:]
    channelInfo?.findAll { it.key?.startsWith("field") }.each { fieldMap[it.value?.trim().toLowerCase()] = it.key }
    return fieldMap
}

private updateChannelInfo() {
    log.debug "Retrieving channel info for ${channelId}"

    def url = "http://api.thingspeak.com/channels/${channelId}/feed.json?key=${channelKey}&results=0"
    httpGet(url) {
        response ->
        if (response.status != 200 ) {
            log.debug "ThingSpeak data retrieval failed, status = ${response.status}"
        } else {
        	log.debug "ThingSpeak data retrieval successful, status = ${response.status}"
            state.channelInfo = response.data?.channel
        }
    }

    state.fieldMap = getFieldMap(state.channelInfo)
}

private logField(evt, Closure c) {
    def deviceName = evt.displayName.trim().toLowerCase() 
    log.debug state.fieldMap
    def fieldNum = state.fieldMap[deviceName]
    if (!fieldNum) {
        log.debug "Device '${deviceName}' has no field"
        return
    }

    def value = c(evt.value)
    log.debug "Logging to channel ${channelId}, ${fieldNum}, value ${value}"

    def url = "http://api.thingspeak.com/update?key=${channelKey}&${fieldNum}=${value}"
    httpGet(url) { 
        response -> 
        if (response.status != 200 ) {
            log.debug "ThingSpeak logging failed, status = ${response.status}"
        } else {
        	log.debug "ThingSpeak logging successful, status = ${response.status}"
        }
    }
}
