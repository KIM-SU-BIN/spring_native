//
var getParameterByName = function(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var hasParameterKey = function(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex.exec(location.search);
    return results !== null;
}

var removeParameter = function(url) {
  return url.split("?")[0].split("#");
}

var getCurrDate = function() {  // YYYY-MM-DD
    var today = new Date();

    var year = today.getFullYear();
    var month = ("0" + (today.getMonth() + 1)).slice(-2);
    var day = ("0" + today.getDate()).slice(-2);

    return "" + year + "-" + month  + "-" + day;
}

var compareToday = function(date) {  // YYYY-MM-DD, old > 0, new < 0
    var today = new Date();

    var year = today.getFullYear();
    var month = ("0" + (today.getMonth() + 1)).slice(-2);
    var day = ("0" + today.getDate()).slice(-2);

    var arr = date.split("-");
    var result = parseInt(arr[0]) - parseInt(year);
    if (result != 0)
        return result;

    var result = parseInt(arr[1]) - parseInt(month);
    if (result != 0)
        return result;

    var result = parseInt(arr[2] - parseInt(day));    
    return result;
}

var compareToday2 = function(date) {  // YYYYMMDD, old > 0, new < 0
    var today = new Date();

    var year = today.getFullYear();
    var month = ("0" + (today.getMonth() + 1)).slice(-2);
    var day = ("0" + today.getDate()).slice(-2);

    var result = parseInt(date.substring(0, 4)) - parseInt(year);
    if (result != 0)
        return result;

    var result = parseInt(date.substring(4, 6)) - parseInt(month);
    if (result != 0)
        return result;

    var result = parseInt(date.substring(6, 8)) - parseInt(day);
    return result;
}

var postFileDownload = function(strUrl, data) {    
    $.ajax({type: "POST", url: strUrl, data: data,
        xhr: function () { 
            var xhr = new XMLHttpRequest(); 
            //xhr.onreadystatechange = function () { 
                xhr.responseType = "blob"; 
            //};
            return xhr; 
        },
        success: function (data, message, xhr) { 
            if (xhr.readyState == 4 && xhr.status == 200) {
                var disposition = xhr.getResponseHeader('Content-Disposition'); 
                var filename; 
                if (disposition && disposition.indexOf('attachment') !== -1) { 
                    var filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/; 
                    var matches = filenameRegex.exec(disposition); 
                    if (matches != null && matches[1])
                        filename = matches[1].replace(/['"]/g, ''); 
                } 
                var blob = new Blob([data], {type: xhr.getResponseHeader('Content-Type')}); 
                var link = document.createElement('a'); 
                link.href = window.URL.createObjectURL(blob); 
                //link.download = filename;
                link.download = decodeURIComponent(filename);
                //link.download = unespace(filename);
                link.click(); 
            } else {
                alert("Failed to download"); 
            } 
        }
    });
}

var DashDate = function(str) {
    if (str == undefined || str == null)
        return "";

    if (str.length == 0 || str.length > 8)
        return str;

    var dashDate = str.substring(0, 4);
    dashDate += "-";
    dashDate += str.substring(4, 6);
    dashDate += "-";
    dashDate += str.substring(6, 8);
    return dashDate;
}
//clearDate = dashDate.replaceAll("-", "");

var SafeVal = function(str) {
    if (str == undefined || str == null)
        return "";

    return str;
}
