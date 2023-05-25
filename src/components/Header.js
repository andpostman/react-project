import React, { useState } from 'react'
import { FaShoppingCart } from "react-icons/fa";
import Order from './Order';

const showOrders = (props) => {
    let summa = 0;
    props.orders.forEach(el => summa += Number.parseFloat(el.price));
    return (
    <div>
        {props.orders.map(el => (
            <Order onDelete={props.onDelete} key={el.id} item={el}/>
        ))}
       <p className='summa'>Сумма: {new Intl.NumberFormat().format(summa)}Р</p> 
    </div>)
}

const showNothing = () => {
    return (
    <div className='empty'>
        <h2>Товаров еще нет в корзине</h2>
    </div>)
}

const showAboutUs = () => {
    return (
    <div className='empty'>
        <h2>Мы - молодой перспективный интернет магазин</h2>
    </div>)
}

const showContacts = () => {
    return (
    <div className='empty'>
        <h2>Для заказа позвоните на данный номер телефона: +7 (999) 999 77 77</h2>
    </div>)
}

export default function Header(props) {
    let [cartOpen, setCartOpen] = useState(false);
    let [aboutOpen, setAboutOpen] = useState(false);
    let [contactsOpen, setContactsOpen] = useState(false);
    return (
        <header>
            <div>
                <span className='logo'>Clothes shop</span>
                <ul className='navigation'>
                    <li onClick={() => setAboutOpen(aboutOpen = !aboutOpen)}>Про нас</li>
                    <li onClick={() => setContactsOpen(contactsOpen = !contactsOpen)}>Контакты</li>
                    <li>Кабинет</li>
                </ul>
                <FaShoppingCart onClick={() => setCartOpen(cartOpen = !cartOpen)} className={`shop-cart-button ${cartOpen && 'active'}`}/>
                {cartOpen && (
                    <div className='shop-cart'>
                        {props.orders.length > 0 ?
                            showOrders(props) : showNothing()}
                    </div>
                )}

                {aboutOpen && (
                    <div className='shop-cart'>
                        {showAboutUs()}
                    </div>
                )}

                {contactsOpen && (
                    <div className='shop-cart'>
                        {showContacts()}
                    </div>
                )}
            </div>
            <div className='presentation'>
                
            </div>
        </header>
    )
}
