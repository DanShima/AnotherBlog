---
title: Github accounts
description: Having multiple github accounts on your computer
date: 2019-06-05
---

## Having multiple github accounts on your computer

After re-organization at work, I had to use a company github account for work instead of my private account. Stuff broke and I couldn't push commits to my private repositories under my private account on the same laptop.

Here are the steps to solve this: 
### Problem:
My laptop is setup with one github account but I want to add another:
### Solution:

1. **go to ssh folder and generate a new ssh key**
```$ ssh-keygen -t rsa -C "email@gmail.com" -f "id_rsa_private" ```
2. **add the new key to your github account using**
```pbcopy < ~/.ssh/id_rsa_private.pub```
3. **in ssh config file you should have**

---
```(Work account, - the default config)
Host github.com
HostName github.com\
User git
IdentityFile ~/.ssh/id_rsa

(Work account - the alternative)
Host github.com-privateusername
HostName github.com
User git
IdentityFile ~/.ssh/id_rsa_private
```
---

4. **choose which key should be active**

```$ ssh-add -D```

```$ ssh-add ~/.ssh/id_rsa```

5. **but wait, I still push commit using the wrong account?! Go to .git config file and make sure the user is the correct one.**
> [user]    name = Danshima    email = email@gmail.com
