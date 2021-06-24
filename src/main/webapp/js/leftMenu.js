/*
window.onload = function() {
    var leftMenu = document.getElementById("leftMenu");
    var leftMenu_ul = leftMenu.getElementsByTagName("ul")[0];
    var leftMenu_ul_li = leftMenu_ul.children;

    leftMenu_ul_li[0].getElementsByTagName("a")[0].onclick = function() {
        showChild(0, leftMenu_ul_li);
    }

    leftMenu_ul_li[1].getElementsByTagName("a")[0].onclick = function() {
        showChild(1, leftMenu_ul_li);
    }

    leftMenu_ul_li[2].getElementsByTagName("a")[0].onclick = function() {
        showChild(2, leftMenu_ul_li);
    }

    leftMenu_ul_li[3].getElementsByTagName("a")[0].onclick = function() {
        showChild(3, leftMenu_ul_li);
    }

} 

function showChild(k, li) {
    var display = li[k].getElementsByTagName("ul")[0].style.display;
    if(String(display) != "block" && String(display) != "none") {
        li[k].getElementsByTagName("ul")[0].style.display = "block";
    } else if(String(display) == "block") {
        li[k].getElementsByTagName("ul")[0].style.display = "none";
    } else {
        li[k].getElementsByTagName("ul")[0].style.display = "block";
    }
}
*/

$(document).ready(function() {
    $("#leftMenu>ul>li a").each(function() {
        $(this).click(function() {
            var flag = $(this).parent().children("ul").is(":visible");
            if(flag) {
                $(this).parent().children("ul").hide();
            } else {
                $(this).parent().children("ul").show();
            }
        })
    })
})



