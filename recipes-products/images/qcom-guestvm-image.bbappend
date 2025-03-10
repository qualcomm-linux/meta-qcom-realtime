# Remove CDSP service from RT guest VM

ROOTFS_POSTPROCESS_COMMAND +=  " remove_cdsp_service; "

remove_cdsp_service () {
    if [ ! -f ${IMAGE_ROOTFS}${sysconfdir}/systemd/system/multi-user.target.wants/cdsprpcd.service ]; then
        rm -rf ${IMAGE_ROOTFS}${systemd_unitdir}/system/cdsprpcd.service
    fi
}
