# SPDX-License-Identifier: GPL-2.0-only
# Copyright (c) 2024-2025, Qualcomm Innovation Center, Inc. All rights reserved.

DESCRIPTION = "Qualcomm L3 Cache Partitioning OOT kernel module (FR203643)"
HOMEPAGE = "https://github.com/rrevdeka/l3-cache-partitioning"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a362c03f8df4e23f8a155e1cb2c45b2a"

SRC_URI = "git://github.com/rrevdeka/l3-cache-partitioning.git;protocol=https;branch=main"

SRCREV = "fcffe87705060b04c54fbb4d302d22a46f47a74d"

inherit module

KERNEL_MODULE_AUTOLOAD += "qcom-cache-partition"

RPROVIDES:${PN} += "kernel-module-qcom-cache-partition"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:aarch64 = "(.*)"

PACKAGE_ARCH = "${MACHINE_ARCH}"
