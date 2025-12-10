SUMMARY = "Basic programs and scripts for edgegateway critical VM"
DESCRIPTION = "Package group to bring in all basic packages for primary VM"

LICENSE = "BSD-3-Clause-Clear"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = ' \
    ${PN} \
    packagegroup-criticalvm-utils \
'

RDEPENDS:${PN} = "\
    packagegroup-container \
    docker-compose \
    packagegroup-filesystem-utils \
    packagegroup-support-utils \
    packagegroup-criticalvm-utils \
    "

RDEPENDS:packagegroup-criticalvm-utils = "\
    mosquitto \
    paho-mqtt-cpp \
    sqlite3 \
    rapidjson \
    dpdk \
"
