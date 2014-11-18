#!/usr/bin/env python

# To be used with WebIOPi <https://code.google.com/p/webiopi/>

import webiopi
import psutil
import os
import json
from threading import Timer
from time import sleep

GPIO = webiopi.GPIO

# setup function is automatically called at WebIOPi startup
def setup():
    # Do nothing
    pass

# loop function is repeatedly called by WebIOPi
def loop():
    # Do Nothing
    sleep(0.1) # Prevent the CPU from running at 100%
    pass

# destroy function is called at WebIOPi shutdown
def destroy():
    # do nothing
    pass

@webiopi.macro
def reboot(t=1):
    Timer(int(t)*60,os.system("sudo reboot")).start()
    return "The system is going DOWN for reboot in %d minute" % t

@webiopi.macro
def getData():
    temp =  round(int(open('/sys/class/thermal/thermal_zone0/temp').read()) / 1e3,1)
    perc = psutil.cpu_percent()
    memAvail = round(psutil.avail_phymem()/1000000,1)
    diskUsage =  psutil.disk_usage('/').percent
    j = {'cpu_temp': temp, 'cpu_perc': perc, 'mem_avail': memAvail, 'disk_usage': diskUsage}
    return json.dumps(j,indent=4, separators=(',', ': '))
