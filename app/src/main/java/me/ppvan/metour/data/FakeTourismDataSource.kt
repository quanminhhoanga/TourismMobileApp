package me.ppvan.metour.data

import me.ppvan.metour.R


object FakeTourismDataSource {

    val dummyCities = listOf(
        "An Giang",
        "Bà rịa Vũng Tàu",
        "Bạc Liêu",
        "Bắc Giang",
        "Bắc Kạn",
        "Bắc Ninh",
        "Bến Tre",
        "Bình Dương",
        "Bình Định",
        "Bình Phước",
        "Bình Thuận",
        "Cà Mau",
        "Cao Bằng",
        "Cần Thơ",
        "Đà Nẵng",
        "Đắk Lắk",
        "Đắk Nông",
        "Điện Biên",
        "Đồng Nai",
        "Đồng Tháp",
        "Gia Lai",
        "Hà Giang",
        "Hà Nam",
        "Hà Nội",
        "Hà Tĩnh",
        "Hải Dương",
        "Hải Phòng",
        "Hậu Giang",
        "Hòa Bình",
        "Hưng Yên",
        "Khánh Hòa",
        "Kiên Giang",
        "Kon Tum",
        "Lai Châu",
        "Lạng Sơn",
        "Lào Cai",
        "Lâm Đồng",
        "Long An",
        "Nam Định",
        "Nghệ An",
        "Ninh Bình",
        "Ninh Thuận",
        "Phú Thọ",
        "Phú Yên",
        "Quảng Bình",
        "Quảng Nam",
        "Quảng Ngãi",
        "Quảng Ninh",
        "Quảng Trị",
        "Sóc Trăng",
        "Sơn La",
        "Tây Ninh",
        "Thái Bình",
        "Thái Nguyên",
        "Thanh Hóa",
        "Thừa Thiên Huế",
        "Tiền Giang",
        "TP Hồ Chí Minh",
        "Trà Vinh",
        "Tuyên Quang",
        "Vĩnh Long",
        "Vĩnh Phúc",
        "Yên Bái"
    )

    private val dummySchedule = listOf(
        Schedule(
            id = 1,
            day = "MONDAY",
            date = "12 APRIL 2021",
            isAvailable = true,
            isSelected = false,
        ),
        Schedule(
            id = 2,
            day = "TUESDAY",
            date = "13 MAY 2021",
            isAvailable = true,
            isSelected = false,
        ),
        Schedule(
            id = 3,
            day = "WEDNESDAY",
            date = "14 JUNE 2021",
            isAvailable = false,
            isSelected = false,
        ),
        Schedule(
            id = 4,
            day = "THURSDAY",
            date = "15 JULY 2021",
            isAvailable = false,
            isSelected = false,
        ),
        Schedule(
            id = 5,
            day = "FRIDAY",
            date = "16 AUGUST 2021",
            isAvailable = true,
            isSelected = false,
        ),
    )

    val dummyTourism = listOf(
        Tourism(
            id = 1,
            name = "Hoàng Thành Thăng Long",
            location = "Điện Biên, Ba Đình, Hà Nội",
            rate = "4.8",
            description =
            "Hoàng thành Thăng Long được xây dựng vào thế kỷ XI dưới triều nhà Lý ở Việt Nam, đánh dấu nền độc lập của Đại Việt. Được xây dựng trên tàn tích của một pháo đài Trung Quốc vào thế kỷ VII, nơi đây là trung tâm chính trị và quyền lực của Đại Việt trong suốt 13 thế kỷ. Ngày nay, Hoàng thành cùng khu khảo cổ số 18 Hoàng Diệu phản ánh nền văn hóa Đông Nam Á đặc sắc nơi Đồng bằng Sông Hồng, cửa ngõ thông thương giữa Trung Hoa cổ đại và Vương quốc cổ Champa",
            ticketPrice = "\$ 25",
            picture = R.drawable.hoangthanhthanglong,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 2,
            name = "Phố cổ Hội An",
            location = "Hội An, Quảng Nam",
            rate = "4.2",
            description =
            "Một đô thị cổ nằm ở hạ lưu sông Thu Bồn, thuộc vùng đồng bằng ven biển tỉnh Quảng Nam, Việt Nam, cách thành phố Đà Nẵng khoảng 30 km về phía Nam. Nhờ những yếu tố địa lý và khí hậu thuận lợi, Hội An từng là một thương cảng quốc tế sầm uất, nơi gặp gỡ của những thuyền buôn Nhật Bản, Trung Quốc và phương Tây trong suốt thế kỷ XVII và XVIII.",
            ticketPrice = "\$ 12",
            picture = R.drawable.hoalo,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 3,
            name = "Danh thắng Tràng An",
            location = "Ninh Bình, Việt Nam",
            rate = "4.5",
            description = "Quần thể di sản thế giới Tràng An mang trong mình những khung cảnh thiên nhiên độc đáo từ đá núi, hệ sinh thái, rừng cây, thảm thực vật, đồng lúa, hồ đầm và những tuyến du thuyền trên sông Ngô Đồng, suối Tiên, sông Vọc, sông Sào Khê, sông Đền Vối, sông Bến Đang. Nơi đây sở hữu những hang động đẹp như động Thiên Hà, động Thiên Thanh, động Tiên, động Tiên Cá, động Vái Giời, động Thủy Cung, hang Bụt, hang Tam Cốc, hang động Tràng An, hang Sinh Dược",
            ticketPrice = "\$ 15",
            picture = R.drawable.hoalo,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 4,
            name = "Cố đô Huế",
            location = "Thừa Thiên Huế",
            rate = "4.7",
            description = "thủ phủ Đàng Trong dưới thời các chúa Nguyễn từ năm 1687 đến 1774, sau đó là thủ đô của triều đại Tây Sơn từ năm 1788 khi Hoàng đế Quang Trung tức Nguyễn Huệ lên ngôi. Khi Nguyễn Ánh lên ngôi vào năm 1802 lấy niên hiệu là Gia Long, ông cũng chọn thành Phú Xuân làm kinh đô cho nhà Nguyễn – triều đại phong kiến cuối cùng trong lịch sử Việt Nam. Huế kết thúc sứ mệnh là thủ đô Việt Nam vào năm 1945 khi vị hoàng đế cuối cùng của nhà Nguyễn là Bảo Đại thoái vị",
            ticketPrice = "\$ 18",
            picture = R.drawable.codohue,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 5,
            name = "Thành nhà Hồ",
            location = "Huyện Vĩnh Lộc, Thanh Hóa",
            rate = "4.5",
            description = "kinh đô nước Đại Ngu (quốc hiệu của Việt Nam dưới thời nhà Hồ), nằm trên địa phận tỉnh Thanh Hóa. Đây là tòa thành kiên cố với kiến trúc độc đáo bằng đá có quy mô lớn hiếm hoi ở Việt Nam, có giá trị và độc đáo nhất, duy nhất còn lại ở tại Đông Nam Á và là một trong rất ít những thành lũy bằng đá còn lại trên thế giới",
            ticketPrice = "\$ 12",
            picture = R.drawable.thanhnhaho,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 6,
            name = "Sa Pa",
            location = "Sa Pa,Lào Cai",
            rate = "4.3",
            description = "nhiều cảnh đẹp tự nhiên như thác Bạc cao khoảng 200m, cầu Mây là một di tích lịch sử của người dân tộc, cổng Trời là điểm cao nhất mà đường bộ có thể đi tới để đứng ngắm đỉnh Fansipan, rừng Trúc, động Tả Phìn, bãi đá cổ Sa Pa nằm trong Thung lũng Mường Hoa. Hàm Rồng là nơi trồng rất nhiều loại hoa, màu sắc sặc sỡ và được trồng theo từng khuôn viên. Ở nơi đây cũng có vườn lan với nhiều loại hoa quý hiếm",
            ticketPrice = "\$ 22",
            picture = R.drawable.hoalo,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 7,
            name = "Sydney",
            location = "South Wales, Australia",
            rate = "4.4",
            description =
            "Sydney menawarkan destinasi yang cocok dijadikan referensi tempat hiburan saat berlibur yakni Taronga Zoo yang berada di Bradleys Head Road. Selain melihat secara langsung, anda juga dapat menyaksikan pertunjukan hewan dan berswafoto dengan mereka",
            ticketPrice = "\$ 27",
            picture = R.drawable.hoalo,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 8,
            name = "Raja Ampat",
            location = "Indonesia",
            rate = "4.9",
            description =
            "Raja Ampat memang menjadi Pulau yang Indah di Indonesia dan diakui oleh dunia bahwa Raja Ampat menjadi Pulau yang sangat indah dan menjadi surganya bagi para penyelam disini anda bisa melihat 80% biota laut di seluruh dunia pada satu tempat, makanya banggalah guys jadi orang Indonesia karena kita memiliki Raja Ampat yang sangat kaya akan biota laut.",
            ticketPrice = "\$ 19",
            picture = R.drawable.hoalo,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 9,
            name = "Manarola",
            location = "La Spezia, Italia",
            rate = "4.2",
            description =
            "Manarola di Italia ini adalah desa nelayan yang berada di atas bukit yang indah, selain berada di atas bukit yang indah di Manarola terdapat bangunan-bangunan yang kuno yang menarik perhatian wisatawan untuk berkunjung ke Manarola.",
            ticketPrice = "\$ 20",
            picture = R.drawable.hoalo,
            isFavorite = false,
            schedule = dummySchedule
        ),
        Tourism(
            id = 10,
            name = "Sudiang",
            location = "Makassar, Indonesia",
            rate = "5.0",
            description =
            "Sudiang itu salah satu nama kelurahan di Makassar. Letaknya ada di ujung utara Kota Makassar dan jadi perbatasan antara Kota Makassar dengan Kabupaten Maros.",
            ticketPrice = "\$ 100",
            picture = R.drawable.hoalo,
            isFavorite = false,
            schedule = dummySchedule
        ),
    )


}