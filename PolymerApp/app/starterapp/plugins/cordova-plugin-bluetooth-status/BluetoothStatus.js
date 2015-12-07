var exec = require('cordova/exec');

var BluetoothStatus = function() {
};

BluetoothStatus.initPlugin = function() {
    //wait for device to be ready
    document.addEventListener("deviceready", function () {
        exec(null, null, "BluetoothStatus", "initPlugin", []);
    }, false);
};

BluetoothStatus.enableBT = function() {
    exec(null, null, "BluetoothStatus", "enableBT", []);
};

BluetoothStatus.disableBT = function() {
    exec(null, null, "BluetoothStatus", "disableBT", []);
};

BluetoothStatus.promptForBT = function() {
    exec(null, null, "BluetoothStatus", "promptForBT", []);
};

BluetoothStatus.hasBT = false;
BluetoothStatus.hasBTLE = false;
BluetoothStatus.BTenabled = false;
BluetoothStatus.iosAuthorized = true;

module.exports = BluetoothStatus;