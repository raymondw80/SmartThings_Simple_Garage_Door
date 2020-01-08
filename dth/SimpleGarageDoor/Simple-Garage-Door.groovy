/**
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
 *  Simple Garage Door Opener
 *
 *  Author: RaymondW80
 *
 *  Date: 2020-01-05
 *
 *	January 5, 2020 v1.0.0  Initial Build
 *
 *
 */
metadata {
	definition (name: "Simple Garage Door Opener", namespace: "raymondw80", author: "RaymondW80", ocfDeviceType: "oic.d.garagedoor") {
		capability "Actuator"
		capability "Switch"
		capability "Sensor"
		capability "Contact Sensor"
	}

	// simulator metadata
	simulator {
	}

	// UI tile definitions
	tiles {
		standardTile("button", "device.switch", width: 2, height: 2, canChangeIcon: true) {
			state "off", label: 'Closed', action: "switch.on", icon: "st.doors.garage.garage-closed", backgroundColor: "#ffffff", nextState: "on"
			state "on", label: 'Open', action: "switch.off", icon: "st.doors.garage.garage-open", backgroundColor: "#00A0DC", nextState: "off"
		}
		main "button"
		details "button"
	}
}

def parse(String description) {
}

def on() {
	sendEvent(name: "switch", value: "on")
    sendEvent(name: "contact", value: "open")
}

def off() {
	sendEvent(name: "switch", value: "off")
    sendEvent(name: "contact", value: "closed")
}
