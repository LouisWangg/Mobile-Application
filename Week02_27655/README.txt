2. a. Program akan keluar secara otomatis dan akan memunculkan pesan error 
      NumberFormatException yang terjadi karena kolom input yang kosong mencoba untuk 
      mengubah data dengan tipe String menjadi bilangan numerik. Salah satucara yang dapat
      dilakukan untuk memperbaiki error tersebut yaitu dengan mengisi kedua kolom input 
      yang ada pada program.
   b. Program akan keluar secara otomatis dan akan memunculkan pesan error 
      NumberFormatException yang terjadi karena kolom input pada Angka2 tidak memiliki 
      nilai. Sehingga ketika program mencoba untuk mengubah kolom kosong dengan tipe 
      String tersebut menjadi bilangan numerik, program malah akan menemukan error. Salah 
      satu cara untuk memperbaiki error tersebut yaitu dengan mengisi nilai pada kolom 
      input Angka2.
   c. Apabila Angka2 diberi nilai 0, maka hasil dari program adalah "Infinite" karena 
      segala bilangan yang dibagi dengan angka 0 akan menghasilkan infinite. Sehingga
      hasil dari infinite tersebut disebabkan oleh bilangan 0 yang terdapat pada Angka2.
      Untuk memperbaiki hasil dari perhitungan tersebut, maka user dapat mengubah nilai
      Angka2 menjadi bilangan lain selain 0.

3. Step-over --> hasil dari debugging dengan teknik Step-over adalah berupa status atau
		 keterangan dari masing-masing variable yang terdapat pada baris tersebut.
		 Serta karena prinsip Step-over berjalan dari baris satu ke baris lainnya
		 hingga menuju titik akhir breakpoint, maka user dapat melihat keterangan
		 setiap variable yang berada dalam breakpoint.
   Step-into --> apabila terdapat metode dalam breakpoint yang telah ditentukan, maka program
		 akan secara langsung menempatkan dirinya menuju file dimana metode tersebut
		 dibuat dan dideklarasi. Sehingga dengan teknik ini, user dapat mengetahui
		 lokasi metode-metode yang digunakan dalam suatu breakpoint.
   Step-out --> fungsi ini akan menjalankan metode yang terdapat dalam breakpoint dan apabila
		telah selesai menjalankan metode tersebut maka program akan memposisikan 
		dirinya pada file dimana metode beserta isi dari metode tersebut berada.
   Resume --> ketika menekan tombol Resume, maka layar handphone yang sebelumnya hanya
              berwarna putih akan memunculkan program kalkulator lagi seperti pada saat
	      dijalankan seperti biasa.