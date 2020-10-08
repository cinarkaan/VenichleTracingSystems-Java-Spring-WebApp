$('document').ready(function () {

    //OgrenciSticker Silme Butonu
    $('.table #deleteButtonOgrenci').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });

    //KurumSticker Silme Butonu
    $('.table #deleteButtonKurum').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });

    //MisafirSticker Silme Butonu
    $('.table #deleteButtonMisafir').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });

    // OgrenciReddet Butonu
    $('.table #redButton').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#redModal #redRef').attr('href', href);
        $('#redModal').modal();
    });

    //Kullanıcı Sil
    $('.table #userDeleteButton').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteUserModal #delUserRef').attr('href', href);
        $('#deleteUserModal').modal();
    });

    $('.table #onayButton').on('click',function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#onayBasvuru #onayRef').attr('href', href);
        $('#onayBasvuru').modal();
    });

});