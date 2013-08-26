package com.sook.android.bluetooth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

public class BluetoothHelper {

	public static CharSequence[] getNameAndAddressBondedDevices() {
		List<String> listItems = new ArrayList<String>();
 		
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
		for (BluetoothDevice d : devices) {
//			mAdapter.add();
//			mAddress.add(d.getAddress());
//			
			listItems.add(d.getName() + " " + d.getAddress().substring(0, 5));
		}
		
		return listItems.toArray(new CharSequence[listItems.size()]);
	}
}
