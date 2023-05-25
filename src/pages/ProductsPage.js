import React from "react";
import Header from "../components/Header";
import Footer from "../components/Footer";
import Items from "../components/Items";
import Categories from "../components/Categories";
import ShowFullItem from "../components/ShowFullItem";
import axios from 'axios';
import ErrorMessage from "../components/ErrorMessage";
import Loader from "../components/Loader";


export class ProductsPage extends React.Component {
  constructor(props){
    super(props)
    this.state = {
      orders: [],
      currentItems: [],
      items: [],
      showFullItem: false,
      fullItem: []
    }
    
    this.addToOrder = this.addToOrder.bind(this)
    this.deleteOrder = this.deleteOrder.bind(this)
    this.chooseCategory = this.chooseCategory.bind(this)
    this.onShowItem = this.onShowItem.bind(this)
  }

    componentDidMount() {
        axios.get('http://localhost:8081/products')
            .then((response) => {
                this.setState({
                    items: response.data,
                    currentItems: response.data
                })
            })
            .catch((error) => {
                console.log(error)
            })
    }

  render () {
    return (
      <div className="wrapper">
        {this.state.loading && <Loader/>}
        {this.state.error && <ErrorMessage error={this.state.error}/>}
        <Header orders={this.state.orders} onDelete={this.deleteOrder}/>
        <Categories chooseCategory={this.chooseCategory}/>
        <Items onShowItem={this.onShowItem} items={this.state.currentItems} onAdd={this.addToOrder}/>
        {this.state.showFullItem && <ShowFullItem onAdd={this.addToOrder} onShowItem={this.onShowItem} item={this.state.fullItem}/>}
        <Footer/>
      </div>
      )
  }

  onShowItem(item){
    this.setState({fullItem: item})
    this.setState({showFullItem: !this.state.showFullItem})
  }

  chooseCategory(category){
    if (category === 'all') {
      this.setState({currentItems: this.state.items})
      return
    }

    this.setState({
      currentItems: this.state.items.filter(el => el.category === category)
    })
  }

  deleteOrder(id) {
    this.setState({orders: this.state.orders.filter(el => el.id !== id)})
  }

  addToOrder(item) {
    let isInArray = false;
    this.state.orders.forEach(el => {
      if(el.id === item.id){
        isInArray = true
      }
    })
    if (!isInArray){
      this.setState({orders: [...this.state.orders, item]})
    }
  }
}

export default ProductsPage
