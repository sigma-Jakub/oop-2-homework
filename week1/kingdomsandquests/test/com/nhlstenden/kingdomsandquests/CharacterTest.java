package com.nhlstenden.kingdomsandquests;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest
{
    private Character createCharacter(int attackDamage, int defensePoints, List<String> attributes, List<String> abilities)
    {
        return new Character(attackDamage, defensePoints, attributes, abilities)
        {
            @Override
            public void useSpecialAbility()
            {

            }
        };
    }

    @Test
    void constructor_validArguments_setsAllFields()
    {
        Character character = this.createCharacter(10, 5, List.of("strong"), List.of("shield bash"));

        assertEquals(10, character.getAttackDamage());
        assertEquals(5, character.getDefensePoints());
        assertEquals(List.of("strong"), character.getAttributes());
        assertEquals(List.of("shield bash"), character.getAbilities());
    }

    @Test
    void setAttackDamage_zeroValue_throwsIllegalArgumentException()
    {
        Character character = this.createCharacter(10, 5, List.of("strong"), List.of("shield bash"));

        assertThrows(IllegalArgumentException.class, () -> character.setAttackDamage(0));
    }

    @Test
    void setDefensePoints_negativeValue_throwsIllegalArgumentException()
    {
        Character character = this.createCharacter(10, 5, List.of("strong"), List.of("shield bash"));

        assertThrows(IllegalArgumentException.class, () -> character.setDefensePoints(-1));
    }

    @Test
    void setAttributes_emptyList_throwsIllegalArgumentException()
    {
        Character character = this.createCharacter(10, 5, List.of("strong"), List.of("shield bash"));

        assertThrows(IllegalArgumentException.class, () -> character.setAttributes(List.of()));
    }

    @Test
    void setAbilities_nullList_throwsIllegalArgumentException()
    {
        Character character = this.createCharacter(10, 5, List.of("strong"), List.of("shield bash"));

        assertThrows(IllegalArgumentException.class, () -> character.setAbilities(null));
    }

    @Test
    void attack_calledOnCharacter_setsStanceToAttacking()
    {
        Character character = this.createCharacter(10, 5, List.of("strong"), List.of("shield bash"));

        character.attack();

        assertEquals("attacking", character.getStance());
    }

    @Test
    void defend_calledOnCharacter_setsStanceToDefending()
    {
        Character character = this.createCharacter(10, 5, List.of("strong"), List.of("shield bash"));

        character.defend();

        assertEquals("defending", character.getStance());
    }
}
