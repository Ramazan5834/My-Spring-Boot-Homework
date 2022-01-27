﻿# MyHomework
Projeyi indirip çalıştırmak isterseniz hata almanız muhtemeldir.Bunun nedeni src/main/resources klasörünün altındaki data.sql dosyasından kaynaklanmaktadır.Dosyanın içindeki 
create table if not exists persistent_logins ( 
  username varchar(100) not null, 
  series varchar(64) primary key, 
  token varchar(64) not null, 
  last_used timestamp not null
);
kodları hariç alt tarafta kalan satırları ilk çalıştırmadan önce silmeniz yada yorum satırına almanız daha sonraki çalıştırmalarınızda ise aktif hale geri getirmeniz gerekmektedir.Çünkü burada bir initialize işlemi yapıldığı için ilk çalıştırmada tabloları bulamıyor ama sonraki çalıştırmalarda ise tekrar tekrar aynı verileri üstüne yazmasın diye tabloların içini boşaltıp yeniden dolduruyor.
