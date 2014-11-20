$(document).ready(function () {

    $("#city").select2({
        placeholder: "місто",
        allowClear: true
    });

    var cities = [
        'Київ',
        'Москва',
        'Нью Йорк',
    ]

    allСities = "";
    $.each(cities, function (index, value) {
        allСities += '<option value="' + value + '">'
        + value + '</option>';
    });

    $("#city").append(allСities);
})

function getWeather() {
    if ($('#city').val() == "") {
        $('#resultWrapper').html('<h2 class="picker">Оберіть місто!&nbsp&nbsp</h2>')
    } else {
        var dateForWeatherParser = {};
        dateForWeatherParser.city = $('#city').val();
        console.log(dateForWeatherParser)

        $.ajax({
            url: "/dateForWeatherParser",
            type: 'GET',
            data: dateForWeatherParser,
            contentType: 'application/json',
            mimeType: 'application/json',


            error: function () {
                console.log("ERROR");
            },

            success: function (result) {
                $('#resultWrapper').html('<style type="text/css">'+
                '.tg {margin-top: 20px; padding-top: 20px;}'+
                '.tg  {border-collapse:collapse;border-spacing:0;border-color:#aaa;}'+
                '.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aaa;color:#333;background-color:#fff;}'+
                '.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#aaa;color:#fff;background-color:#f38630;}'+
                '.tg .tg-96re{font-weight:bold;font-size:18px;color:#1987ff;text-align:center}'+
                '.tg .tg-cbvs{background-color:#1987ff;text-align:center}'+
                '.tg .tg-nu6i{font-weight:bold;font-size:14px;color:#1987ff;text-align:center}'+
                '</style>'+
                '<table class="tg">'+
                '<tr>'+
                '<th class="tg-cbvs">Місто</th>'+
                '<th class="tg-cbvs">Температура, c</th>'+
                '<th class="tg-cbvs">Вологість, %</th>'+
                '<th class="tg-cbvs">Тиск, Па</th>'+
                '<th class="tg-cbvs">Шв вітру, м/с</th>'+
                '<th class="tg-cbvs">Напр вітру</th>'+
                '<th class="tg-cbvs">Хмарність</th>'+
                '</tr>'+
                '<tr>'+
                '<td class="tg-96re">'+result.city_name+'</td>'+
                '<td class="tg-nu6i">'+Math.round((result.temperature_value*100))/100+'</td>'+
                '<td class="tg-nu6i">'+result.humidity_value+'</td>'+
                '<td class="tg-nu6i">'+result.pressure_value+'</td>'+
                '<td class="tg-nu6i">'+result.speed_value+'</td>'+
                '<td class="tg-nu6i">'+result.direction_name+'</td>'+
                '<td class="tg-nu6i">'+'<img src="http://openweathermap.org/img/w/'+result.weather_icon+'.png">'+'</td>'+
                '</tr>'+
                '</table>')
            }
        })


    }
}