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
            mimeType: "text/html; charset=UTF-8",

            success: function (result) {
                console.log(result);
            },
            error: function () {
                console.log("ERROR");
            }
        })


    }
}