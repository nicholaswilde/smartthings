# Raspberry Pi REST Server
A python script file for running with [WebIOPi](https://code.google.com/p/webiopi/) and [SmartThings](http://www.smartthings.com/)

## Installation Instructions
 1. Install WebIOPi on your Raspberry Pi using [these directions](https://code.google.com/p/webiopi/wiki/INSTALL).
 2. Install psutil for Python3
   * Install [pip-3.2](https://github.com/pypa/pip)
```
$ sudo apt-get install python3-pip
```
   2. Install [psutil](https://github.com/giampaolo/psutil)
```
$ sudo pip-3.2 install psutil
```
   3. Check that the install was successful
```
$ python3
>>> import psutil
>>> exit()
```
 2. Reboot your Raspberry Pi.
```
$ sudo reboot 
```
 3. Check to make sure that WebIOPi is up and running by going to http://<yourip>:8000/
 4. Download and install raspberrypi.py to some directory.
 5. Using the Framework basis tutorial as a baseline:
   1. Edit `/etc/webiopi/config:`
```
$ sudo nano /etc/webiopi/config
```
```
...
[SCRIPTS]
raspberrypi = /<somedirectory>/raspberry.py
...
```
 6. Stop the current WebIOPi process
```
$ sudo service webiopi stop
```
 7. Manually start WebIOPi to make sure there aren't any errors.
```
$ sudo webiopi -d -c /etc/webiopi/config
```
 8. Check that WebIOPi is up and running by going to http://<yourip>:8000/
 9. Using your farvorite REST client, test to see that the REST commands are working.
```
username: webiopi
password: raspberry
```
```
POST http://<yourip>:8000/macros/getDiskUsage
43.9
```
