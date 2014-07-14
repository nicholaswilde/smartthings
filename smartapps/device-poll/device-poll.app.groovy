/**
 *  Device Poll
 *
 *  Copyright 2014 Steve Herrell
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
definition(
    name: "Device Poll",
    namespace: "steve.herrell@gmail.com",
    author: "Steve Herrell",
    description: "Poll particular devices to make sure readings are up to date.",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Meta/window_contact.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/window_contact@2x.png"
)

preferences {
    section("Devices To Poll") {
		input "pollingDevices", "capability.polling", multiple: true, title: "Pollable Devices"
	}
    section("Polling Interval (defaults to 15 min)") {
		input "pollingInterval", "decimal", title: "Number of minutes", required: false
	}
}

def installed() {
	log.debug "Installed with settings: ${settings}"

    doPoll()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

    doPoll()
}

def doPoll() {

	log.debug "running doPoll"

	pollingDevices.poll()

    def timeOut = (pollingInterval != null && pollingInterval != "") ? pollingInterval : 15

	runIn( timeOut * 60, "doPoll",)
}
