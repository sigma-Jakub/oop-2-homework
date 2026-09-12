package com.nhlstenden.uservalidation;

import java.util.List;

public class PasswordValidation implements Validation
{
    private static final List<String> SPECIAL_CHARACTERS_LIST = List.of("!", "\"", "#", "$", "%",
            "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[",
            "\\", "]", "^", "_", "`", "{", "|", "}", "~");
    private static final List<String> NUMBERS_LIST = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private boolean areSpacesAllowed;
    private boolean areSpecialCharactersMandatory;
    private boolean areNumbersMandatory;
    private boolean isLowercaseSymbolMandatory;
    private boolean isUppercaseSymbolMandatory;

    public PasswordValidation(boolean areSpacesAllowed, boolean areSpecialCharactersMandatory, boolean areNumbersMandatory,
                              boolean isLowercaseSymbolMandatory, boolean isUppercaseSymbolMandatory)
    {
        this.setAreSpacesAllowed(areSpacesAllowed);
        this.setAreSpecialCharactersMandatory(areSpecialCharactersMandatory);
        this.setAreNumbersMandatory(areNumbersMandatory);
        this.setLowercaseSymbolMandatory(isLowercaseSymbolMandatory);
        this.setUppercaseSymbolMandatory(isUppercaseSymbolMandatory);
    }

    public boolean isAreSpacesAllowed()
    {
        return this.areSpacesAllowed;
    }

    public void setAreSpacesAllowed(boolean areSpacesAllowed)
    {
        this.areSpacesAllowed = areSpacesAllowed;
    }

    public boolean isAreSpecialCharactersMandatory()
    {
        return this.areSpecialCharactersMandatory;
    }

    public void setAreSpecialCharactersMandatory(boolean areSpecialCharactersMandatory)
    {
        this.areSpecialCharactersMandatory = areSpecialCharactersMandatory;
    }

    public boolean isAreNumbersMandatory()
    {
        return this.areNumbersMandatory;
    }

    public void setAreNumbersMandatory(boolean areNumbersMandatory)
    {
        this.areNumbersMandatory = areNumbersMandatory;
    }

    public boolean isLowercaseSymbolMandatory()
    {
        return this.isLowercaseSymbolMandatory;
    }

    public void setLowercaseSymbolMandatory(boolean lowercaseSymbolMandatory)
    {
        this.isLowercaseSymbolMandatory = lowercaseSymbolMandatory;
    }

    public boolean isUppercaseSymbolMandatory()
    {
        return this.isUppercaseSymbolMandatory;
    }

    public void setUppercaseSymbolMandatory(boolean uppercaseSymbolMandatory)
    {
        this.isUppercaseSymbolMandatory = uppercaseSymbolMandatory;
    }

    private static boolean containsSpecialCharacter(String password)
    {
        for (String c : SPECIAL_CHARACTERS_LIST)
        {
            if (password.contains(c))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean containsNumber(String password)
    {
        for (String n : NUMBERS_LIST)
        {
            if (password.contains(n))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean containsLowercaseSymbol(String password)
    {
        return (!password.toUpperCase().equals(password));
    }

    private static boolean containsUppercaseSymbol(String password)
    {
        return (!password.toLowerCase().equals(password));
    }

    @Override
    public boolean isValidated(User user)
    {
        String password = user.getPassword();

        if (!this.areSpacesAllowed && password.contains(" "))
        {
            return false;
        }

        if (this.areSpecialCharactersMandatory && !containsSpecialCharacter(password))
        {
            return false;
        }

        if (this.areNumbersMandatory && !containsNumber(password))
        {
            return false;
        }

        if (this.isLowercaseSymbolMandatory && !containsLowercaseSymbol(password))
        {
            return false;
        }

        if (this.isUppercaseSymbolMandatory && !containsUppercaseSymbol(password))
        {
            return false;
        }

        return true;
    }
}
