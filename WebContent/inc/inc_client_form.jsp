<fieldset>
	<legend>Informations client</legend>
	
	<label for="nomClient">Nom <span class="requis">*</span></label>
	<input type="text" id="nomClient" name="nomClient" value="${client.nom}" size="20" maxlength="20" />
	<span class="erreur">${form.erreurs['nomClient']}</span>
	<br />
	
	<label for="prenomClient">Pr�nom </label>
	<input type="text" id="prenomClient" name="prenomClient" value="${client.prenom}" size="20" maxlength="20" />
	<span class="erreur">${form.erreurs['prenomClient']}</span>
	<br />
	
	<label for="adresseClient">Adresse de livraison <span class="requis">*</span></label>
	<input type="text" id="adresseClient" name="adresseClient" value="${client.adresse}" size="20" maxlength="20" />
	<span class="erreur">${form.erreurs['adresseClient']}</span>
	<br />
	
	<label for="telephoneClient">Num�ro de t�l�phone <span class="requis">*</span></label>
	<input type="text" id="telephoneClient" name="telephoneClient" value="${client.telephone}" size="20" maxlength="20" />
	<span class="erreur">${form.erreurs['telephoneClient']}</span>
	<br />
	
	<label for="emailClient">Adresse email</label>
	<input type="email" id="emailClient" name="emailClient" value="${client.email}" size="20" maxlength="60" />
	<span class="erreur">${form.erreurs['emailClient']}</span>
	<br />
</fieldset>