<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output 
        method="html"
        encoding="UTF-8"
        doctype-public="-//W3C//DTD HTML 4.01//EN"
        doctype-system="http://www.w3.org/TR/html4/strict.dtd"
        indent="yes" />
    
    <xsl:template match="/">
        <html>
            <head>
                <title>Mon répertoire téléphonique</title>
                <link type="text/css" rel="stylesheet" href="style.css"/>
            </head>
            <body>
                <table>
                    <xsl:for-each select="repertoire/personne">
                        <xsl:choose>
                            <xsl:when test="@sexe = 'masculin'">
                                <xsl:call-template name="homme">
                                           <xsl:with-param name="personne" select="." />
                                       </xsl:call-template>
                            </xsl:when>
                            <xsl:otherwise>
                                <xsl:call-template name="femme">
                                           <xsl:with-param name="personne" select="." />
                                       </xsl:call-template>
                            </xsl:otherwise>
                        </xsl:choose>
                            </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template name="homme">
        <xsl:param name="personne" />
        <tr>
            <td  class="homme">
                <xsl:call-template name="afficherPersonne">
                    <xsl:with-param name="personne" select="$personne" />
                </xsl:call-template>
            </td>
        </tr>
    </xsl:template>
    
    <xsl:template name="femme">
        <xsl:param name="personne" />
        <tr>
            <td  class="femme">
                <xsl:call-template name="afficherPersonne">
                    <xsl:with-param name="personne" select="$personne" />
                </xsl:call-template>
            </td>
        </tr>
    </xsl:template>
    
    <xsl:template name="afficherPersonne">
        <xsl:param name="personne" />
        <h1>
            <xsl:value-of select="$personne/nom" />
            &#160;
            <xsl:value-of select="$personne/prenom" />
        </h1>
        
        <xsl:call-template name="afficherAdresse">
            <xsl:with-param name="adresse" select="$personne/adresse" />
        </xsl:call-template>
        
        <xsl:if test="count($personne/telephones) != 0">
            <xsl:call-template name="afficherTelephones">
                <xsl:with-param name="telephones" select="$personne/telephones" />
            </xsl:call-template>
        </xsl:if>
        
        <xsl:if test="count($personne/emails) != 0">
            <xsl:call-template name="afficherEmails">
                <xsl:with-param name="emails" select="$personne/emails" />
            </xsl:call-template>
        </xsl:if>
    </xsl:template>
    
    <xsl:template name="afficherAdresse">
        <xsl:param name="adresse" />
        <p class="adresse" >
            <xsl:value-of select="$adresse/numero" />
            &#160;
            <xsl:value-of select="$adresse/voie" />
            <br/>
            <xsl:value-of select="$adresse/codePostal" />
            &#160;
            <xsl:value-of select="$adresse/ville" />
            <br/>
            <xsl:value-of select="$adresse/pays" />
        </p>
    </xsl:template>
    
    <xsl:template name="afficherTelephones">
        <xsl:param name="telephones" />
        <h2>Numéros de téléphones :</h2>
        <ul>
            <xsl:for-each select="$telephones/telephone">
                <xsl:call-template name="afficherTelephone">
                    <xsl:with-param name="telephone" select="." />
                </xsl:call-template>
            </xsl:for-each>
        </ul>
    </xsl:template>
    
    <xsl:template name="afficherTelephone">
        <xsl:param name="telephone" />
        <li>
            <xsl:value-of select="$telephone/@type" /> : <xsl:value-of select="$telephone" />
        </li>
    </xsl:template>
    
    <xsl:template name="afficherEmails">
        <xsl:param name="emails" />
        <h2>Adresses Emails :</h2>
        <ul>
            <xsl:for-each select="$emails/email">
                <xsl:call-template name="afficherEmail">
                    <xsl:with-param name="email" select="." />
                </xsl:call-template>
            </xsl:for-each>
        </ul>
    </xsl:template>
    
    <xsl:template name="afficherEmail">
        <xsl:param name="email" />
        <li>
            <xsl:value-of select="$email/@type" /> : <xsl:value-of select="$email" />
        </li>
    </xsl:template>
</xsl:stylesheet>
