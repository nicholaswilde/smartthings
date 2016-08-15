/**
 *  Samsung TV Remote
 *
 *  Author: Nicholas Wilde
 *  Date: 2014-08-31
 *
 *  Based on Brad Butner's SmartThings Samsung TV Remote <https://github.com/bradmb/SmartThings-Samsung-TV-Remote>
 *  
 *  Commands taken from http://forum.samygo.tv/viewtopic.php?f=12&t=1792
 *  
 *  This currently only allows you to trigger actions on your TV if you press the app or trigger it
 *  with a virtual button
 *
 */

// Automatically generated. Make future change here.
definition(
    name: 		"Samsung TV Remote",
    namespace: 		"nicholaswilde",
    author: 		"Nicholas Wilde",
    description: 	"Control Samsung Smart TVs using SmartThings",
    categorhy:      "SmartThings Labs",
    iconUrl: 		"http://icons.iconarchive.com/icons/icons8/windows-8/512/Network-Remote-Control-icon.png",
    iconX2Url: 		"http://icons.iconarchive.com/icons/icons8/windows-8/512/Network-Remote-Control-icon.png")

preferences {
    section("Samsung TV Settings") {
    	def commands = [
            "UP",
            "DOWN",
            "LEFT",
            "RIGHT",
            "3",
            "VOLUP",
            "4",
            "5",
            "6",
            "VOLDOWN",
            "7",
            "8",
            "9",
            "MUTE",
            "CHDOWN",
            "0",
            "CHUP",
            "PRECH",
            "GREEN",
            "YELLOW",
            "CYAN",
            "ADDDEL",
            "SOURCE",
            "INFO",
            "PIP_ONOFF",
            "PIP_SWAP",
            "PLUS100",
            "CAPTION",
            "PMODE",
            "TTX_MIX",
            "TV",
            "PICTURE_SIZE",
            "AD",
            "PIP_SIZE",
            "MAGIC_CHANNEL",
            "PIP_SCAN",
            "PIP_CHUP",
            "PIP_CHDOWN",
            "DEVICE_CONNECT",
            "HELP",
            "ANTENA",
            "CONVERGENCE",
            "11",
            "12",
            "AUTO_PROGRAM",
            "FACTORY",
            "3SPEED",
            "RSURF",
            "ASPECT",
            "TOPMENU",
            "GAME",
            "QUICK_REPLAY",
            "STILL_PICTURE",
            "DTV",
            "FAVCH",
            "REWIND",
            "STOP",
            "PLAY",
            "FF",
            "REC",
            "PAUSE",
            "TOOLS",
            "INSTANT_REPLAY",
            "LINK",
            "FF_",
            "GUIDE",
            "REWIND_",
            "ANGLE",
            "RESERVED1",
            "ZOOM1",
            "PROGRAM",
            "BOOKMARK",
            "DISC_MENU",
            "PRINT",
            "RETURN",
            "SUB_TITLE",
            "CLEAR",
            "VCHIP",
            "REPEAT",
            "DOOR",
            "OPEN",
            "WHEEL_LEFT",
            "POWER",
            "SLEEP",
            "2",
            "DMA",
            "TURBO",
            "1",
            "FM_RADIO",
            "DVR_MENU",
            "MTS",
            "PCMODE",
            "TTX_SUBFACE",
            "CH_LIST",
            "RED",
            "DNIe",
            "SRS",
            "CONVERT_AUDIO_MAINSUB",
            "MDC",
            "SEFFECT",
            "DVR",
            "DTV_SIGNAL",
            "LIVE",
            "PERPECT_FOCUS",
            "HOME",
            "ESAVING",
            "WHEEL_RIGHT",
            "CONTENTS",
            "VCR_MODE",
            "CATV_MODE",
            "DSS_MODE",
            "TV_MODE",
            "DVD_MODE",
            "STB_MODE",
            "CALLER_ID",
            "SCALE",
            "ZOOM_MOVE",
            "CLOCK_DISPLAY",
            "AV1",
            "SVIDEO1",
            "COMPONENT1",
            "SETUP_CLOCK_TIMER",
            "COMPONENT2",
            "MAGIC_BRIGHT",
            "DVI",
            "HDMI",
            "W_LINK",
            "DTV_LINK",
            "APP_LIST",
            "BACK_MHP",
            "ALT_MHP",
            "DNSe",
            "RSS",
            "ENTERTAINMENT",
            "ID_INPUT",
            "ID_SETUP",
            "ANYNET",
            "POWEROFF",
            "POWERON",
            "ANYVIEW",
            "MS",
            "MORE",
            "PANNEL_POWER",
            "PANNEL_CHUP",
            "PANNEL_CHDOWN",
            "PANNEL_VOLUP",
            "PANNEL_VOLDOW",
            "PANNEL_ENTER",
            "PANNEL_MENU",
            "PANNEL_SOURCE",
            "AV2",
            "AV3",
            "SVIDEO2",
            "SVIDEO3",
            "ZOOM2",
            "PANORAMA",
            "4_3",
            "16_9",
            "DYNAMIC",
            "STANDARD",
            "MOVIE1",
            "CUSTOM",
            "AUTO_ARC_RESET",
            "AUTO_ARC_LNA_ON",
            "AUTO_ARC_LNA_OFF",
            "AUTO_ARC_ANYNET_MODE_OK",
            "AUTO_ARC_ANYNET_AUTO_START",
            "AUTO_FORMAT",
            "DNET",
            "HDMI1",
            "AUTO_ARC_CAPTION_ON",
            "AUTO_ARC_CAPTION_OFF",
            "AUTO_ARC_PIP_DOUBLE",
            "AUTO_ARC_PIP_LARGE",
            "AUTO_ARC_PIP_SMALL",
            "AUTO_ARC_PIP_WIDE",
            "AUTO_ARC_PIP_LEFT_TOP",
            "AUTO_ARC_PIP_RIGHT_TOP",
            "AUTO_ARC_PIP_LEFT_BOTTOM",
            "AUTO_ARC_PIP_RIGHT_BOTTOM",
            "AUTO_ARC_PIP_CH_CHANGE",
            "AUTO_ARC_AUTOCOLOR_SUCCESS",
            "AUTO_ARC_AUTOCOLOR_FAIL",
            "AUTO_ARC_C_FORCE_AGING",
            "AUTO_ARC_USBJACK_INSPECT",
            "AUTO_ARC_JACK_IDENT",
            "NINE_SEPERATE",
            "ZOOM_IN",
            "ZOOM_OUT",
            "MIC",
            "HDMI2",
            "HDMI3",
            "AUTO_ARC_CAPTION_KOR",
            "AUTO_ARC_CAPTION_ENG",
            "AUTO_ARC_PIP_SOURCE_CHANGE",
            "HDMI4",
            "AUTO_ARC_ANTENNA_AIR",
            "AUTO_ARC_ANTENNA_CABLE",
            "AUTO_ARC_ANTENNA_SATELLITE",
            "EXT1",
            "EXT2",
            "EXT3",
            "EXT4",
            "EXT5",
            "EXT6",
            "EXT7",
            "EXT8",
            "EXT9",
            "EXT10",
            "EXT11",
            "EXT12",
            "EXT13",
            "EXT14",
            "EXT15",
            "EXT16",
            "EXT17",
            "EXT18",
            "EXT19",
            "EXT20",
            "EXT21",
            "EXT22",
            "EXT23",
            "EXT24",
            "EXT25",
            "EXT26",
            "EXT27",
            "EXT28",
            "EXT29",
            "EXT30",
            "EXT31",
            "EXT32",
            "EXT33",
            "EXT34",
            "EXT35",
            "EXT36",
            "EXT37",
            "EXT38",
            "EXT39",
            "EXT40",
			"EXT41"
        ]
        commands.sort()
        input "settingIpAddress", "text", title: "IP Address", description: "192.168.1.100", required: true
        input "settingMacAddress", "text", title: "MAC Address",description: "01:23:45:67:89:ab", required: true
        input "tvCommand", "enum", title: "Perform This Command", metadata:[values: commands], required: true
    }
	section("When this switch is turned pushed") {
    	input "master", "capability.switch", title: "Which?", required: true
    }
}

def installed() {
    log.debug "Installed with settings: ${settings}"
    initialize()
}

def updated() {
    log.debug "Updated with settings: ${settings}"
    unsubscribe()
    initialize()
}

def initialize() {
    subscribe(app, appTouch)
    subscribe(master, "switch.on", switchHandler)
    tvAction("AUTHENTICATE")
}

def appTouch(evt) {
    log.debug "appTouch: $evt"
    tvAction(tvCommand)
}

def switchHandler(evt) {
	log.debug "${master} switch turned ${evt}"
	tvAction(tvCommand)
}

private tvAction(key) {
    log.debug "Executing ${tvCommand}"

    // Standard Connection Data
    def appString = "iphone..iapp.samsung"
    def appStringLength = appString.getBytes().size()

    def tvAppString = "iphone.UN60ES8000.iapp.samsung"
    def tvAppStringLength = tvAppString.getBytes().size()

    def remoteName = "SmartThings".encodeAsBase64().toString()
    def remoteNameLength = remoteName.getBytes().size()

    // Device Connection Data
    def ipAddress = settingIpAddress.encodeAsBase64().toString()
    def ipAddressLength = ipAddress.getBytes().size()
    def ipAddressHex = settingIpAddress.tokenize( '.' ).collect { String.format( '%02x', it.toInteger() ) }.join()
    log.debug "IP Address (HEX): ${ipAddressHex}"

    def macAddress = settingMacAddress.replaceAll(":","").encodeAsBase64().toString()
    def macAddressLength = macAddress.getBytes().size()

    // The Authentication Message
    def authenticationMessage = "${(char)0x64}${(char)0x00}${(char)ipAddressLength}${(char)0x00}${ipAddress}${(char)macAddressLength}${(char)0x00}${macAddress}${(char)remoteNameLength}${(char)0x00}${remoteName}"
    def authenticationMessageLength = authenticationMessage.getBytes().size()
    
    def authenticationPacket = "${(char)0x00}${(char)appStringLength}${(char)0x00}${appString}${(char)authenticationMessageLength}${(char)0x00}${authenticationMessage}"

    // If our initial run, just send the authentication packet so the prompt appears on screen
    if (key == "AUTHENTICATE") {
	    sendHubCommand(new physicalgraph.device.HubAction(authenticationPacket, physicalgraph.device.Protocol.LAN, "${ipAddressHex}:D6D8"))
    } else {
        // Build the command we will send to the Samsung TV
        def command = "KEY_${key}".encodeAsBase64().toString()
        def commandLength = command.getBytes().size()

        def actionMessage = "${(char)0x00}${(char)0x00}${(char)0x00}${(char)commandLength}${(char)0x00}${command}"
        def actionMessageLength = actionMessage.getBytes().size()

        def actionPacket = "${(char)0x00}${(char)tvAppStringLength}${(char)0x00}${tvAppString}${(char)actionMessageLength}${(char)0x00}${actionMessage}"

        // Send both the authentication and action at the same time
        sendHubCommand(new physicalgraph.device.HubAction(authenticationPacket + actionPacket, physicalgraph.device.Protocol.LAN, "${ipAddressHex}:D6D8"))
    }
}