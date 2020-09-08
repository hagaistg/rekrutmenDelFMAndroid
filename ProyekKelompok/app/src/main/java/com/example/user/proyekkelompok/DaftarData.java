package com.example.user.proyekkelompok;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by User on 5/14/2019.
 */

class DaftarData {
    public static String[][] data = new String[][]{
            {"Harry Potter", "Salah seorang ulama dan khatib terkemuka di Masjid Besar Kasultanan Yogyakarta pada masa itu, dan ibu dari K.H. Ahmad Dahlan adalah puteri dari H. Ibrahim yang juga menjabat penghulu Kesultanan Ngayogyakarta Hadiningrat pada masa itu. KH. Ahmad Dahlan telah mempelopori kebangkitan ummat Islam untuk menyadari nasibnya sebagai bangsa terjajah yang masih harus belajar dan berbuat.", "Harga : 150.000"},
            {"Sikancil Baik hati", "Jenderal TNI Anumerta Ahmad Yani (juga dieja Achmad Yani; lahir di Purworejo, Jawa Tengah, 19 Juni 1922 – meninggal di Lubang Buaya, Jakarta, 1 Oktober 1965 pada umur 43 tahun) adalah komandan Tentara Nasional Indonesia Angkatan Darat, dan dibunuh oleh anggota Gerakan 30 September saat mencoba untuk menculik dia dari rumahnya.", "Harga : 150.000"},
            {"Drama UTS PAM", "Sutomo (lahir di Surabaya, Jawa Timur, 3 Oktober 1920 – meninggal di Padang Arafah, Arab Saudi, 7 Oktober 1981 pada umur 61 tahun) lebih dikenal dengan sapaan akrab oleh rakyat sebagai Bung Tomo, adalah pahlawan yang terkenal karena peranannya dalam membangkitkan semangat rakyat untuk melawan kembalinya penjajah Belanda melalui tentara NICA, yang berakhir dengan pertempuran 10 November 1945 yang hingga kini diperingati sebagai Hari Pahlawan.", "Harga : 150.000"},
            {"Jawaban yang tertukar", "Jenderal TNI (Purn.) Gatot Soebroto (lahir di Sumpiuh, Banyumas, Jawa Tengah, 10 Oktober 1907 – meninggal di Jakarta, 11 Juni 1962 pada umur 54 tahun) adalah tokoh perjuangan militer Indonesia dalam merebut kemerdekaan dan juga pahlawan nasional Indonesia. Ia dimakamkan di Ungaran, kabupaten Semarang.", "Harga : 150.000"},
            {"Indah Pada waktuNya", "Raden Mas Soewardi Soerjaningrat (EBI: Suwardi Suryaningrat, sejak 1922 menjadi Ki Hadjar Dewantara, EBI: Ki Hajar Dewantara, beberapa menuliskan bunyi bahasa Jawanya dengan Ki Hajar Dewantoro; lahir di Pakualaman, 2 Mei 1889 – meninggal di Yogyakarta, 26 April 1959 pada umur 69 tahun; selanjutnya disingkat sebagai \"Soewardi\" atau \"KHD\") adalah aktivis pergerakan kemerdekaan Indonesia, kolumnis, politisi, dan pelopor pendidikan bagi kaum pribumi Indonesia dari zaman penjajahan Belanda. Ia adalah pendiri Perguruan Taman Siswa, suatu lembaga pendidikan yang memberikan kesempatan bagi para pribumi untuk bisa memperoleh hak pendidikan seperti halnya para priyayi maupun orang-orang Belanda.", "Harga : 150.000"},
    };
        public static ArrayList<Akun> getListData(DatabaseHelper handler, Akun produk){
            ArrayList<Akun> list = new ArrayList<>();
            ArrayList<Akun> lists = handler.getAllDataProfile();

            for(Akun profileModel : list){
                String log =
                        "EMAIL: " + profileModel.getEmail();
                System.out.println(log);

                Log.e("db", "" + log);

                //set to the model

                produk.setEmail(profileModel.getEmail());
                //profile.setJangkauan(profileModel.getJangkauan());

                lists.add(produk);

            }
            return lists;
        }
}

