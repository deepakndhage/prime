cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/at.gofg.sportscomputer.powermanagement/www/powermanagement.js",
        "id": "at.gofg.sportscomputer.powermanagement.device",
        "clobbers": [
            "window.powerManagement"
        ]
    },
    {
        "file": "plugins/com.megster.cordova.bluetoothserial/www/bluetoothSerial.js",
        "id": "com.megster.cordova.bluetoothserial.bluetoothSerial",
        "clobbers": [
            "window.bluetoothSerial"
        ]
    },
    {
        "file": "plugins/cordova-plugin-bluetooth-status/BluetoothStatus.js",
        "id": "cordova-plugin-bluetooth-status.BluetoothStatus",
        "clobbers": [
            "cordova.plugins.BluetoothStatus"
        ]
    },
    {
        "file": "plugins/cordova-plugin-whitelist/whitelist.js",
        "id": "cordova-plugin-whitelist.whitelist",
        "runs": true
    },
    {
        "file": "plugins/de.appplant.cordova.plugin.background-mode/www/background-mode.js",
        "id": "de.appplant.cordova.plugin.background-mode.BackgroundMode",
        "clobbers": [
            "cordova.plugins.backgroundMode",
            "plugin.backgroundMode"
        ]
    },
    {
        "file": "plugins/com.dsquare.controllerplugin/www/ControllerPlugin.js",
        "id": "com.dsquare.controllerplugin.ControllerPlugin",
        "clobbers": [
            "ControllerPlugin"
        ]
    },
    {
        "file": "plugins/org.apache.cordova.device/www/device.js",
        "id": "org.apache.cordova.device.device",
        "clobbers": [
            "device"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "at.gofg.sportscomputer.powermanagement": "1.1.0",
    "com.megster.cordova.bluetoothserial": "0.4.3",
    "cordova-plugin-bluetooth-status": "1.0.3",
    "cordova-plugin-whitelist": "1.0.0",
    "de.appplant.cordova.plugin.background-mode": "0.6.4",
    "com.dsquare.controllerplugin": "0.0.1",
    "org.apache.cordova.device": "0.3.0"
}
// BOTTOM OF METADATA
});