package com.issi.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 *
 * @see com.issi.factories.ExplicitWaitFactory
 * @see com.issi.pages.BasePage
 */
public enum WaitStrategy {
    CLICKABLE,
    PRESENCE,
    VISIBLE,
    NONE;
}
