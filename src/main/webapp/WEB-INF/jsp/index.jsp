<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<span>
        <div class="wrapper container">
            <h2 class="picker">Оберіть місто!&nbsp&nbsp
                <select id="city">
                    <option></option>
                </select>
            </h2>
        </div>

    <div class="buttonWrapper">
        <button type="button" class="btn btn-sample btnSearch" onclick="getWeather()">Погода?</button>
    </div>
    <div id="resultWrapper" class="resultWrapper">
    </div>

</span>





