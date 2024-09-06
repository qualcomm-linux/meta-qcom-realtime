# config inc
FILESEXTRAPATHS:prepend := "${THISDIR}/configs:"

SRC_URI:append = " \
    file://qcom_rt.cfg \
    file://0001-arch-Kconfig-Add-RT-kernel-support.patch \
    "
