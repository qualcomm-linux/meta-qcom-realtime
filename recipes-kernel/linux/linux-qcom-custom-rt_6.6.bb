require recipes-kernel/linux/linux-qcom-custom_6.6.bb

SECTION = "RT kernel"
SUMMARY = "Linux Real time kernel for QCOM devices"
DESCRIPTION = "Recipe to build real time Linux kernel"
LICENSE = "GPLv2.0-with-linux-syscall-note"

SRC_URI:append = "https://cdn.kernel.org/pub/linux/kernel/projects/rt/6.6/older/patch-6.6.40-rt36.patch.gz;md5sum=f73a3034ad62073b56ecdafa2bed5f86 \
		file://qcom_rt.cfg \
		file://0001-arch-Kconfig-Add-RT-kernel-support.patch \
		file://0001-QCLINUX-arm64-defconfig-qcom-Disable-bcl-for-RT-kern.patch \
		"

S = "${WORKDIR}/kernel"
KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/qcom_rt.cfg"
