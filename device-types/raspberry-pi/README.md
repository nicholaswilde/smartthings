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
$ ...
[SCRIPTS]
myproject = /home/pi/myproject/python/script.py
...
```
