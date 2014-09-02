package com.ocypode.bluetooth;

import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

public class BluetoothHelper {

	public static Set<BluetoothDevice> getPairedBluetoothDevices() {
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		return bluetoothAdapter.getBondedDevices();
	}
}
