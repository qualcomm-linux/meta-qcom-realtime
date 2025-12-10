inherit systemd externalsrc

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append:qcom = " \
    file://realtime-presetting.service \
    file://realtime_presetting.sh \
    file://realtime_presetting_qcm6490.sh \
    file://realtime_presetting_qcs9100.sh \
    file://realtime_presetting_qcs8300.sh \
"

do_install:append:qcom() {
    install -d ${D}${systemd_unitdir}/system/
    install -d ${D}${systemd_unitdir}/system/multi-user.target.wants/
    install -d ${D}${sysconfdir}/initscripts/

    # kernel debug configuration
    install -m 0755 ${WORKDIR}/realtime_presetting.sh ${D}${sysconfdir}/initscripts/realtime_presetting.sh
    install -m 0755 ${WORKDIR}/realtime_presetting_qcm6490.sh ${D}${sysconfdir}/initscripts/realtime_presetting_qcm6490.sh
    install -m 0755 ${WORKDIR}/realtime_presetting_qcs9100.sh ${D}${sysconfdir}/initscripts/realtime_presetting_qcs9100.sh
    install -m 0755 ${WORKDIR}/realtime_presetting_qcs8300.sh ${D}${sysconfdir}/initscripts/realtime_presetting_qcs8300.sh
    install -m 0644 ${WORKDIR}/realtime-presetting.service -D ${D}${systemd_unitdir}/system/realtime-presetting.service
    ln -sf ${systemd_unitdir}/system/realtime-presetting.service ${D}${systemd_unitdir}/system/multi-user.target.wants/realtime-presetting.service

}

S = "${WORKDIR}"

INITSCRIPT_PACKAGES =+ "${PN}-realtime-presetting"
INITSCRIPT_NAME:${PN}-realtime-presetting = "realtime_presetting.sh"

SYSTEMD_AUTO_ENABLE:irqbalance = "disable"

PACKAGES =+ "${PN}-realtime-presetting"
FILES:${PN}-realtime-presetting += "${systemd_unitdir}/system/realtime-presetting.service ${systemd_unitdir}/system/multi-user.target.wants/realtime-presetting.service ${sysconfdir}/initscripts/realtime_presetting_qcm6490.sh ${sysconfdir}/initscripts/realtime_presetting_qcs9100.sh ${sysconfdir}/initscripts/realtime_presetting_qcs8300.sh ${sysconfdir}/initscripts/realtime_presetting.sh"
