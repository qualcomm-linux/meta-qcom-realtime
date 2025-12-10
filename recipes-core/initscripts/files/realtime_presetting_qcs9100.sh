#!/bin/sh
# Copyright (c) Qualcomm Technologies, Inc. and/or its subsidiaries.
# SPDX-License-Identifier: BSD-3-Clause-Clear

#disable tracing
echo 0 > /sys/kernel/tracing/tracing_on

# Disable timer migration
echo 0 > /proc/sys/kernel/timer_migration

# Affine kernel worqueue to housekeeping cpus
for wq in /sys/devices/virtual/workqueue/*; do
    if [ -w "$wq/cpumask" ]; then
        echo 7F > "$wq/cpumask"
    fi
done

# disable cpu-idle
for cpu in /sys/devices/system/cpu/cpu[0-7]*; do
    for state in 0 1 2; do
        file="$cpu/cpuidle/state${state}/disable"
        if [ -w "$file" ]; then
            echo 1 > $file
        fi
    done
done

# CPU in performance
for policy in /sys/devices/system/cpu/cpufreq/policy*; do
    if [ -w "$policy/scaling_governor" ]; then
        echo performance > "$policy/scaling_governor"
    fi
done

# Disable rt accounting
echo -1 > /proc/sys/kernel/sched_rt_runtime_us

# CPUs to ALLOW handling IRQs (i.e. system CPUs/non-RT CPUs)
ALLOW_CPUS="0,1,2,3,4,5,6"

# Convert list to hex bitmask
cpu_list_to_mask() {
    CPUs="$1"
    MASK=0
    for cpu in $(echo $CPUs | tr ',' ' '); do
        MASK=$((MASK | (1 << cpu)))
    done
    printf "%x\n" "$MASK"
}

MASK=$(cpu_list_to_mask "$ALLOW_CPUS")

echo "Setting IRQ affinity to CPUs: $ALLOW_CPUS (mask=0x$MASK)"

# Loop through all IRQs and update their affinity
for irq in /proc/irq/[0-9]*; do
	irq_num=$(basename "$irq")
	smp_file="$irq/smp_affinity"

	if [ -w "$smp_file" ]; then
		echo "$MASK" > "$smp_file" 2>/dev/null || echo "️ masking Failed for $irq_num"
	else
		echo "Skipping IRQ $irq_num (permission denied or not movable)"
	fi
done
