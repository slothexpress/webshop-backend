# Kodtest Fullstack Open Source

Uppgiften utgörs av två delar som tillsammans bildar en enkel websida som visar upp produker och information om dem. 
Del 1 består av skapandet av ett API som exponerar funktioner för hämtning och manipulering av produktdata och del 2 handlar om att bygga en frontend till APIet. 

Du bestämmer själv vilka språk/teknologier du vill använda för de olika delarna. 

Övergripande krav:
- Forka inte detta repot, utan utför alla förändringar i detta repot
- Använd versionshantering med tydliga commitmeddelanden
- Commita ändringar kontinuerligt
- Följ kodstandarder
- Enkel felhantering
- Lägg tydliga kommentarer i koden
- Inkludera README med beskrivning hur man startar projektet

Vi uppskattar att det tar runt en dag att göra klart denna uppgiften, men det är helt ok att sitta länge bara du meddelar oss vid inlämning. 

## Del 1 (backend)
Skapa en applikation som vid start läser in befintliga produkter från `https://kodtest.azurewebsites.net/api/products?code=MWZOJunmBNEPDGxldyIKSplsqq/8Sv4c6KvgZ1vyh4Z9wCaw6rqJIA==`.

Efter inläsning är det din applikation som ansvarar för produktdatan, antingen genom att hålla den i minnet eller använda en databas. 

Bygg sedan ett REST API med möjligheten att:
- Hämta alla produkter
- Hämta enstaka produkter som identifieras med ID
- Ta bort enstaka produkter som identifieras med ID
- Lägga till nya produkter

Det ska vara möjligt att använda Postman för att testa APIet och hämta, lägga till och ta bort produkter. Om man lägger till eller tar bort produkter ska det reflekteras på hemsidan om man laddar om den. 

Extrauppgifter:
- Säkra APIet med någon form av autentisering 
- Lägg till kundkorgsfunktionalitet
  - Lägga till vara i kundkorgen
  - Ändra antal på en vara i kundkorgen
  - Visa totala summan för kundkorgen

## Del 2 (frontend)
Bygg en hemsida som visar upp produktdatan från ditt API. 

Hemsidan bör bestå av minst
- En sida som listar alla produkter och information om dem
- En sida med detaljerad information om produkter
- Funktionalitet för att klicka på en produkt i listan och länkas till den detaljerade sidan om den produkten

Exempeldesign: `https://www.figma.com/file/LaITTNxxRSoolJvgmzUMMM/Commerce-Coding-Assignment`

