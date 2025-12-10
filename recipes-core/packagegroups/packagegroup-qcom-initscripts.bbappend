SUMMARY = "initscripts"
PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

RDEPENDS:${PN}:append = " \
  initscripts-realtime-presetting \
"
