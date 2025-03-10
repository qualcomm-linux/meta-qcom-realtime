FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

do_install:append:qcom () {
    echo "kernel.timer_migration=0" >> ${D}${sysconfdir}/sysctl.conf
}
