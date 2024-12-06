SUMMARY = "A guestVM image for edgegateway support"

LICENSE = "BSD-3-Clause-Clear"

inherit core-image features_check extrausers image-adbd

CORE_IMAGE_BASE_INSTALL += " \
    packagegroup-qcom-vm-guest \
    packagegroup-qcom-criticalvm \
"

IMAGE_FEATURES += "ssh-server-openssh splash tools-debug allow-root-login post-install-logging enable-adbd"


REQUIRED_DISTRO_FEATURES = "pam systemd"

EXTRA_USERS_PARAMS = "\
    useradd -r -s /bin/false system; \
    usermod -p '\$6\$UDMimfYF\$akpHo9mLD4z0vQyKzYxYbsdYxnpUD7B7rHskq1E3zXK8ygxzq719wMxI78i0TIIE0NB1jUToeeFzWXVpBBjR8.' root; \
    "

BAD_RECOMMENDATIONS:append = " lxc"

IMAGE_LINGUAS = " "
