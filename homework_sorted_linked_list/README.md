# Sortirane linkane liste

Iskoristit ćemo naše poznavanje algoritama za sortiranje, te novonaučene vještine rukovanja linkanim listama, da napravimo novu strukturu: sortirana linkana lista.

Ova linkana lista se razlikuje od obične linkane liste po tome što su elementi u njoj uvijek poredani u rastućem redoslijedu, bez obzira na to kojim su se redoslijedom dodavali u listu.

Za ovu svrhu vam je dostavljena klasa `SortedIntList` koja sadrži već neke manje ili više implementirane metode.

Zadaci:

1. Implementirajte metodu `add(int n)` tako da doda broj `n` u linkanu listu uzimajući u obzir da linkana lista nakon pokretanja treba biti sortirana u rastućem redoslijedu
  * ako vam se ovaj zadatak pokaže kao suviše komplikovan, a želite pokušati uraditi ostale zadatke, implementirajte `add(n)` metodu tako da dodaje element na kraj liste. Slične primjere smo već radili na GitHub-u.

2. Dovršite implementaciju metode `toArray()` tako da vraća niz koji sadrži sve elemente iz liste u ispravnom redoslijedu.

3. *(bonus)* Prepišite metodu `getLength()` tako da računa dužinu liste reukurzivno umjesto iterativno.
  * **HINT**: Sama metoda `getLength()` ne treba da bude rekurzivna, već će vam trebati pomoćna metoda koja prima argument tipa `Node`. Ne zaboravite da je linkana lista definisana rekurzivno: svaki čvor linkane liste pokazuje na prvi čvor ostatka linkane liste :)
  * *(malo manji bonus)* Ako ne uspijete implementirati rekurzivno brojanje elemenata, još uvijek možete spasiti obraz ako prepišete `getLength()` metodu tako da koristi `for` umjesto `while` petlje. Za ovo imate par hintova u kôdu objavljenom nakon današnjeg predavanja.

Ako ispravno uradite 1. i 2. zadatak, ovo bi trebao biti rezultat pokretanja programa:

```
Unesite proizvoljan broj pozitivnih brojeva:
3
2
4
1
5
0
Unijeli ste 5 pozitivnih brojeva
Poredani brojevi:
1
2
3
4
5
```

I još jedan primjer;

```
Unesite proizvoljan broj pozitivnih brojeva:
1
2
3
4
5
0
Unijeli ste 5 pozitivnih brojeva
Poredani brojevi:
1
2
3
4
5
```

I još jedan:

```
Unesite proizvoljan broj pozitivnih brojeva:
5
4
3
2
1
0
Unijeli ste 5 pozitivnih brojeva
Poredani brojevi:
1
2
3
4
5
```