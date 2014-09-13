## Raspberry Pi Device Type
Monitor your [Raspberry Pi](http://www.raspberrypi.org/) with [SmartThings](http://www.smartthings.com/) and [WebIOPi](https://code.google.com/p/webiopi/).

The setup requires three things; the SmartThings Raspberry Pi Device Type, WebIOPi, and the WebIOPi python script macro (raspberrypi.py).

### WebIOPi Installation Instructions
 - Following [these instructions](https://code.google.com/p/webiopi/wiki/INSTALL?tm=6) for installing WebIOPi.

### WebIOPi Python Script Marco Installation Instructions
The python script macro is used by WebIOPi to pipe out the information from the Raspberry Pi to SmartThings using a REST API. The script requires psutil for Python3 which also requires pip-3.2.
 - Install [pip-3.2](https://github.com/pypa/pip)
```
$ sudo apt-get install python3-pip
```
 - Install [psutil](https://github.com/giampaolo/psutil)
```
$ sudo pip-3.2 install psutil
```
 - Check that the install was successful
```
$ python3
>>> import psutil
>>> exit()
```
 - Reboot your Raspberry Pi.
```
$ sudo reboot 
```
 - Create a directory and download the python script. See [this for reference](https://code.google.com/p/webiopi/wiki/Tutorial_Basis).
```
$ mkdir -p ~/myproject/python
$ cd ~/myproject/python/
$ wget https://raw.githubusercontent.com/nicholaswilde/smartthings/master/device-types/raspberry-pi/raspberrypi.py
$ sudo chmod +x raspberrypi.py
```
 - Add the script to the WebIOPi configuration file. See [this for reference](https://code.google.com/p/webiopi/wiki/Tutorial_Basis).
```
$ sudo nano /etc/webiopi/config
```
```
...
[SCRIPTS]
myproject = /home/pi/myproject/python/raspberrypi.py
...
```
 - Save the configuration file and restart the `webiopi` service
```
$ sudo service webiopi restart
```

### Rasberry Pi SmartThings Device Type Installation Instructions
 - Create and account or log into the [SmartThings Web IDE](https://graph.api.smartthings.com/login/auth).
 - Click on `My Device Types` from the navigation menu.
 - Click on `+ New SmartDevice` button.
 - Fill in the `Name` field and click on the `Create` button. Don't worry about filling out everything else.
 - Paste the code from the [raspberry-pi.device.groovy](https://github.com/nicholaswilde/smartthings/blob/master/device-types/raspberry-pi/raspberry-pi.device.groovy) file.
 - Click on `Save` in the IDE.
 - Click on `Publish -> For Me` in the IDE.
 
 ### Raspberry Pi SmartThings Device Installation Instructions
The device type is a generic template for a specific type of device. The Raspberry Pi device itself needs to be added to SmartThings.
 - Click on `My Devices` in the SmartThings Web IDE navigation menu.
 - Click on `+ New Device` button.
 - Specify the following fields:
   - Name: Raspberry Pi
   - Device Network Id: 123 (can be anything at the moment because the Raspberry Pi device type will change it for you).
   - Type: Raspberry Pi (Name of your new device type)
   - Version: PUblished
   - Location: <your location, e.g. `Home`>
   - Hub: <your hub> This is a must or else the Raspberry Pi device won't work!
   - Group: Can leave blank.
 - 
