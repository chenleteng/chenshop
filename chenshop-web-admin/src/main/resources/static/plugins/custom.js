var Custom = function () {
    var handleFormatDateTime = function (date) {
        if (typeof(date) == "undefined") {
            return "";
        }
        var oDate = new Date(date),
            oYear = oDate.getFullYear(),
            oMonth = oDate.getMonth() + 1,
            oDay = oDate.getDate(),
            oHour = oDate.getHours(),
            oMin = oDate.getMinutes(),
            oSen = oDate.getSeconds(),
            oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour
            ) + ':' + getzf(oMin) + ':' + getzf(oSen);//最后拼接时间
        return oTime;
// 补 0 操作, 当时间数据小于 10 的时候，给该数据前面加一个 0
        function getzf(num) {
            if (parseInt(num) < 10) {
                num = '0' + num;
            }
            return num;
        }
    };
    return {
        formatDateTime: function (date) {
            return handleFormatDateTime(date);
        }
    };
}();
