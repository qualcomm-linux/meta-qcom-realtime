# Look for .patch files of linux-qcom-custom
FILESEXTRAPATHS:prepend := "${QCOMHWEBASE}/recipes-kernel/linux/linux-qcom-custom:"

require recipes-kernel/linux/linux-qcom-custom_6.6.bb

SECTION = "RT kernel"
SUMMARY = "Linux Real time kernel for QCOM devices"
DESCRIPTION = "Recipe to build real time Linux kernel"
LICENSE = "GPLv2.0-with-linux-syscall-note"

SRC_URI:append = "https://cdn.kernel.org/pub/linux/kernel/projects/rt/6.6/older/patches-6.6.116-rt66.tar.gz;md5sum=1391eb1ceaba92092c24edf051cefa00 \
		file://qcom_rt.cfg \
		file://0001-arch-Kconfig-Add-RT-kernel-support.patch \
		file://0001-QCLINUX-Disable-bcl-driver-config-for-RT-kernel.patch \
		"

S = "${WORKDIR}/kernel"
KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/qcom_rt.cfg"
