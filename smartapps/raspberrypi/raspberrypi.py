
#!/usr/bin/env python

import webiopi
import psutil
import os
from threading import Timer

GPIO = webiopi.GPIO

# setup function is automatically called at WebIOPi startup
def setup():
    # Do nothing
    pass

# loop function is repeatedly called by WebIOPi
def loop():
    # Do Nothing
    pass

# destroy function is called at WebIOPi shutdown
def destroy():
    # do nothing
    pass

@webiopi.macro
def getCPUTemp():
    return round(int(open('/sys/class/thermal/thermal_zone0/temp').read()) / 1e3,1)

@webiopi.macro
def getCPUPercent():
    return psutil.cpu_percent()

@webiopi.macro
def getMemAvail():
    return round(psutil.avail_phymem()/1000000,1)

@webiopi.macro
def getDiskUsage():
    return psutil.disk_usage('/').percent

@webiopi.macro
def reboot(t=1):
    Timer(int(t)*60,os.system("sudo reboot")).start()
    return "The system is going DOWN for reboot in %d minute" % t
