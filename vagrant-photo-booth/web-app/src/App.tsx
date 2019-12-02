import React, { Component } from 'react';
import './style.css';
import { Icon } from 'antd';
import Overlay from './Overlay';

interface AppProps { }
interface AppState {
    name: string;
    divStyle: any;
    overlayVisible: boolean;
}

const endpointConfig = {
    endpointBseURI: "http://localhost:8081"
}

class App extends Component<AppProps, AppState> {
    picList: string[] = [];
    counter: number = 0;

    constructor(props: AppProps) {
        super(props);
        this.state = {
            name: 'React',
            divStyle: {
                backgroundImage: 'url(https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&h=650&w=940)',
                WebkitTransition: 'all',
                msTransition: 'all',
                backgroundPosition: 'center',
                backgroundRepeat: 'no-repeat',
                backgroundSize: 'cover',
                height: '100%',
            },
            overlayVisible: false
        };
    }

    componentDidMount() {
        this.getPictures();
        this.startInterval();

        window.addEventListener('keydown', event => {
            //console.log("keydown " +event.code);

            if(event.code==='Enter' && !this.state.overlayVisible){
                this.handleCameraClick();
            }
        });
    }



    private startInterval(){
        setInterval(() => {
            //console.log("length: " +this.picList.length);
            if(++this.counter>=this.picList.length){
                this.counter = 0;
            }
            this.setState({
                divStyle: {
                    backgroundImage: 'url(' +this.picList[this.counter] +')',
                    backgroundPosition: 'center',
                    backgroundRepeat: 'no-repeat',
                    backgroundSize: 'cover',
                    height: '100%',
                    transition: 'background 400ms ease-in 400ms',
                    WebkitTransition:'background 400ms ease-in 400ms',
                    msTransition: 'background 400ms ease-in 400ms',
                }
            });
        }, 4000);
    }

    private getPictures(){
        this.picList = [];
        fetch(endpointConfig.endpointBseURI+'/image/all')
            .then(res => res.json())
            .then((data) => {
                //console.log("=>" +JSON.stringify(data))
                data.map((item: string) => {
                    this.addPicture(item);
                    //this.picList.push(endpointConfig.endpointBseURI +'/image/get/' +item);
                });
            })
            .catch(console.log)
    }

    private addPicture = (filename: string) => {
        this.picList.push(endpointConfig.endpointBseURI +'/image/get/' +filename);
        //console.log('==> ' +JSON.stringify(this.picList));
    }

    private handleCameraClick = () => {
        //console.log("handleCameraClick ");
        this.setState({
            overlayVisible: true
        });
    }

    private closeOverlay = () => {
        //console.log("closeOverlay ");
        this.setState({
            overlayVisible: false
        });
    }


    render() {
        return (
            <div style={this.state.divStyle}>
                <div className="camera" onClick={this.handleCameraClick} >
                    <Icon type="camera" style={{ fontSize: '60px', color:'white' }} />
                </div>
                {
                    this.state.overlayVisible ? <Overlay closeFunction={this.closeOverlay} endpointConfig={endpointConfig} addPicture={this.addPicture} /> : ''
                }
            </div>
        );
    }
}

export default App;
