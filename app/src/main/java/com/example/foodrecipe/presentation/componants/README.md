
### **README.md**

# **Components Directory**
This folder contains reusable UI components that enhance modularity and maintainability for the project. Components are organized based on their purpose.

---

## **Directory Structure**

```
components/
│
├── buttons/                     # Reusable button components
│   ├── auth/                    # Buttons related to authentication
│   │   ├── EmailAuthButton.kt   # Button for email authentication
│   │   ├── ForgetPasswordButton.kt # Button for 'Forget Password' action
│   │   └── SocialAuthButtons.kt # Buttons for social login (Google, Facebook, etc.)
│   │
│   ├── BackButton.kt            # Button for navigation back
│   ├── FilterButton.kt          # Button for filtering content
│   ├── FollowButton.kt          # Button for follow actions
│   ├── RecipeButtons.kt         # Button specific to recipes
│   └── ShareButton.kt           # Button to share content
│
├── cards/                       # Card components used for various UI items
│   ├── [Future components...]   # Example: RecipeCard.kt, IngredientCard.kt
│
├── Animations.kt                # Custom animations for UI transitions
├── GeneralSections.kt           # General UI section templates
├── Images.kt                    # Image-related components or helpers
├── InputFields.kt               # Text input fields or forms
├── Lists.kt                     # List components (e.g., LazyColumn)
├── Text.kt                      # Text styling or composables
└── TopBar.kt                    # Top bar components for app screens
```

---

## **Usage**
### **Buttons**
All button components are located under the `buttons` folder. For authentication-related buttons, refer to `buttons/auth`.

Example usage for `EmailAuthButton.kt`:
```kotlin
EmailAuthButton(
    text = "Login",
    onClick = { /* Handle Email Authentication */ })

```

### **Cards**
Card components will contain composables like `RecipeCard` or `IngredientCard`. Import them like this:
```kotlin
SearchedRecipeCard(meal = Recipe.data, modifier = Modifier)
```

### **Other Components**
- **InputFields.kt**: Contains text fields, password inputs, etc.
- **TopBar.kt**: For creating consistent app bars at the top of your screens.

---

## **Contributing**
If you’re adding new components:
1. Place them in the appropriate folder (`buttons`, `cards`, etc.).
2. Follow the naming convention: `ComponentName.kt`.
3. Update this README if needed.

---

## **License**
This project is licensed under [MIT License](https://opensource.org/licenses/MIT).

---

Let me know if you'd like this customized further or expanded with more instructions! 😊