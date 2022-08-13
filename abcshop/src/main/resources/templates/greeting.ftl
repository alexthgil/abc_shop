<#import "parts/common.ftl" as c>

<@c.page>
    <div id="carouselExInterval" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="10000">
                <img src="/img/carousel_b_1.jpg" class="d-block w-100">
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="/img/carousel_s_1.jpg" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="/img/carousel_s_2.jpg" class="d-block w-100">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExInterval"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExInterval"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

</@c.page>