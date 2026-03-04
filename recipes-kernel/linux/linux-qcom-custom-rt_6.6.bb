# Look for .patch files of linux-qcom-custom
FILESEXTRAPATHS:prepend := "${QCOMHWEBASE}/recipes-kernel/linux/linux-qcom-custom:"

require recipes-kernel/linux/linux-qcom-custom_6.6.bb

SECTION = "RT kernel"
SUMMARY = "Linux Real time kernel for QCOM devices"
DESCRIPTION = "Recipe to build real time Linux kernel"
LICENSE = "GPLv2.0-with-linux-syscall-note"

SRC_URI:append = "https://cdn.kernel.org/pub/linux/kernel/projects/rt/6.6/older/patch-6.6.119-rt67.patch.gz;md5sum=e78f515f30aa9fb315f36ce38bcf7932 \
		file://qcom_rt.cfg \
		file://0001-arch-Kconfig-Add-RT-kernel-support.patch \
		file://0001-QCLINUX-Disable-bcl-driver-config-for-RT-kernel.patch \
		"

S = "${WORKDIR}/kernel"
KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/qcom_rt.cfg"
