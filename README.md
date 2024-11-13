


### Hedeflerimiz:

### Zoo Rest Api

 ### Başlangıç
 * Uygulaman  ```9000``` portunda.
 * Bir hayvanat bahçesi için rest api dizaynı
 
 ### Görev 1
 * main metodunuz ```com.workintech.zoo``` paketi altında olmalıdır
 * ```com.workintech.zoo``` paketi altında ```controller```, ```entity```, ```exceptions``` isminde 3 adet daha paket oluşturunuz.
 * Project Lombok'u dependency olarak uygulamanıza ekleyin.
 * ```entity``` paketinin altına ```Koala``` ve ```Kangaroo``` isimli iki tane sınıf oluşturunuz.
 * ```Koala``` sınıfı ```id, name, weight, sleepHour, gender``` isimli 5 fielda sahip olmalı.
 * ```Kangaroo``` sınıfı ```id, name, height, weight, gender, isAggressive``` isimli 6 fielda sahip olmalı.
 * ```Koala``` ve ```Kangaroo``` sınıfları project lombok annotationlarını kullanarak oluşturulmalılar.

 ### Görev 2
 * ```KangarooController``` ve ```KoalaController``` isimli 2 tane controller yazmalısınız.
 * ```KangarooController``` içirisinde kangaroo objelerini tutacak bir adet ```kangaroos``` isminde map tutmalısınız. Controller bean ilk oluştuğunda bu map tanımlanmalı.
 * Amacımız CRUD işlemlerini tanımlayan endpointler yazmak. 
 * [GET]/workintech/kangaroos => tüm kangaroo listini dönmeli.
 * [GET]/workintech/kangaroos/{id} => İlgili id deki kangaroo objesini dönmeli.
 * [POST]/workintech/kangaroos => Bir adet kangaroo objesini kangaroos listesine ekler
 * [PUT]/workintech/kangaroos/{id} => İlgili id deki kangaroo objesinin değerlerini yeni gelen data ile değiştirir.
 * [DELETE]/workintech/developers/{id} => İlgili id değerindeki kangaroo objesini listeden siler.
 * ```KoalaController``` içirisinde koala objelerini tutacak bir adet ```koalas``` isminde Map tutmalısınız. Controller bean ilk oluştuğunda bu map tanımlanmalı.
 * [GET]/workintech/koalas => tüm koala listini dönmeli.
 * [GET]/workintech/koalas/{id} => İlgili id deki koala objesini dönmeli.
 * [POST]/workintech/koalas => Bir adet koala objesini koala listesine ekler
 * [PUT]/workintech/koalas/{id} => İlgili id deki koala objesinin değerlerini yeni gelen data ile değiştirir.
 * [DELETE]/workintech/koalas/{id} => İlgili id değerindeki koala objesini listeden siler.

 ### Görev 3
 * Her endpointin hata fırlatabileceği senaryolar düşünülmeli 
 * ```exceptions``` paketi altına bu Error sınıfları oluşturulmalı.
 * ```exceptions``` paketi altında ```ZooException``` adında bir sınıf yazınız. Bu sınıf RuntimeException sınıfını extends etmeli.
 * ```ZooException``` sınıfı içerisine bir tane instance variable olarak HttpStatus tipinde bir değişken ekleyiniz.
 * ```exceptions``` paketi altında ```ZooErrorResponse``` adında bir sınıf daha tanımlayın. İçerisinde ````String message, int status, long timestamp```` adında 3 tane değişken tanımlayınız.
 * ```exceptions``` paketi altında ```ZooGlobalExceptionHandler``` adında bir sınıf ekleyiniz. 
 * ```ZooGlobalExceptionHandler``` içerisinde ZooException ve Exception sınıflarını handle eden 2 tane metodu olmalı. Hata yakalndığında ```ZooErrorResponse``` mesaj olarak dönülmeli.
 * Kullanım Örneği; KangarooController getById yaparken ilgili id yoksa ZooException throw etmeli.
 * Error Handling Global bir merkezden yönetilmeli. Controller sınıflarının altında olmamalı.
 * ```@Slf4j``` bir şekilde hata dönüldüğünde ```error logu``` basılmalı.
 
