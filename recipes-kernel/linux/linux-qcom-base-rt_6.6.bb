require recipes-kernel/linux/linux-qcom-base_6.6.bb

SECTION = "RT kernel"
SUMMARY = "Linux Real time kernel for QCOM devices"
DESCRIPTION = "Recipe to build real time Linux kernel"
LICENSE = "GPLv2.0-with-linux-syscall-note"

S = "${WORKDIR}/git"
KERNEL_CONFIG_FRAGMENTS:append = " ${WORKDIR}/qcom_rt.cfg"

# Apply qcom patches
require ${BPN}/configs.inc
require ${BPN}/rt-patch.inc
