#!/bin/sh
# Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
# SPDX-License-Identifier: BSD-3-Clause-Clear

if [ -f /sys/devices/soc0/soc_id ]; then
    soc_id=`cat /sys/devices/soc0/soc_id`
fi

case "$soc_id" in
    497|498|475|515)
        /etc/initscripts/realtime_presetting_qcm6490.sh
        ;;
    534|667|676)
        /etc/initscripts/realtime_presetting_qcs9100.sh
        ;;
    606|674|675)
        /etc/initscripts/realtime_presetting_qcs8300.sh
        ;;

    *)
        # Empty default case
        ;;
esac

