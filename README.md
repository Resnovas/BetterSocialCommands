# BetterSocialCommands

A super basic extension to [BetterSocial](https://www.spigotmc.org/resources/%E2%9C%85-bettersocial-1-8-1-16-%E2%80%A2-texture-database-regex-professional-look.83437/)

## Adds 
- Commands can be run after linking
- Command can be run after unlinking

## Permissions

| Command | Permission | Default |
| --- | --- | --- |
| Reload | `bettersocial.admin` | op |

## Config
```yml
identifiers:
  # Each Identifier needs to be unique, otherwise it will throw errors
  # Make sure this lines up with the identifiers in "social.yml" within "BetterSocial" folder
  discord:
    enabled: true # Should this identifier be used?
    linkedCommands: # The commands that should be executed after linked event
      - discordsrv link %bettersocial_value_discord%
    unlinkedCommands: # The commands that should be executed after linked event
      - 'console: discordsrv unlink %player_name%'
```

## Dependencies

[BetterSocial](https://www.spigotmc.org/resources/%E2%9C%85-bettersocial-1-8-1-16-%E2%80%A2-texture-database-regex-professional-look.83437/)

[PlaceHolderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/)