/**
 *  Spark Core Illuminance Sensor
 *
 *  Copyright 2014 Nicholas Wilde
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
 
preferences {
        input "deviceId", "text", title: "Device ID", required: true
        input "token", "password", title: "Access Token", required: true
        input "sparkVar", "text", title: "Spark Variable", required: true
}

metadata {
	definition (name: "Spark Core Illuminance Sensor", namespace: "nicholaswilde/smartthings-spark-core-illuminance-sensor", author: "Nicholas Wilde") {
		capability "Polling"
		capability "Refresh"
		capability "Illuminance Measurement"
	}

	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		valueTile("illuminance", "device.illuminance", width: 2, height: 2) {
            state "illuminance", label:'${currentValue}', unit: "LUX",
            backgroundColors:[
					[value: 21, color: "#153591"],
                    [value: 51, color: "#1e9cbb"],
                    [value: 101, color: "#90d2a7"],
                    [value: 401, color: "#44b621"],
                    [value: 1001, color: "#f1d801"],
                    [value: 10001, color: "#d04e00"],
                    [value: 25001, color: "#bc2323"]
				]
        }
        standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat") {
        	state "default", action:"refresh.refresh", icon: "st.secondary.refresh"
        }
        main "illuminance"
        details(["illuminance", "refresh"])
    }
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
}

// handle commands
def poll() {
	log.debug "Executing 'poll'"
	getReading()
}

def refresh() {
	log.debug "Executing 'refresh'"
    getReading()
}

// Get the sensor reading
private getReading() {
    //Spark Core API Call
    def readingClosure = { response ->
	  	log.debug "Reading request was successful, $response.data.result"
      	sendEvent(name: "illuminance", value: response.data.result)
	}

    httpGet("https://api.spark.io/v1/devices/${deviceId}/${sparkVar}?access_token=${token}", readingClosure)
}

