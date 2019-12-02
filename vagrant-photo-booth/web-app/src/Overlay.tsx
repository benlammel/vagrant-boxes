import React, { Component } from 'react';
import './style.css';
import Countdown from './Countdown';
import Preview from "./Preview";


interface AppProps {
    closeFunction: any,
    endpointConfig: any,
    addPicture: any
}
interface AppState {
    countdownVisible: boolean,
    waitingVisible: boolean,
    previewVisible: boolean,
    picURI: string
}

export default class Overlay extends Component<AppProps, AppState> {

    constructor(props: AppProps){
        super(props);

        this.state = {
            countdownVisible: false,
            waitingVisible: false,
            previewVisible: false,
            picURI:''
        };
    }

    componentDidMount() {
        this.setState({
            countdownVisible: true,
            waitingVisible: false,
            previewVisible: false,
        });
    }

    private closeOverlay = () => {
        console.log("closeOverlay in overlay");
        this.props.closeFunction();
    }

    private triggerForCapture = () => {
        console.log("triggerForCapture");
        fetch(this.props.endpointConfig.endpointBseURI+'/camera/capture')
            .then(res => res.json())
            .then((data) => {

                if(data.fileName!==undefined){
                    //console.log("=>" +data.fileName)
                    this.props.addPicture(data.fileName);
                    this.setState({
                        countdownVisible: false,
                        waitingVisible: false,
                        previewVisible: true,
                        picURI: this.props.endpointConfig.endpointBseURI+'/image/get/' +data.fileName,
                    });
                } else {
                    this.setState({
                        countdownVisible: true,
                        waitingVisible: false,
                        previewVisible: false,
                    });
                }

            })
            .catch((err) => {
                console.log("error " +err);
            });
    }

    private triggerAfterCountdown = () => {
        //console.log('triggerAfterCountdown');
        if(this.state.countdownVisible){
            this.setState({
                countdownVisible: false,
                waitingVisible: true,
                previewVisible: false,
            });
        }
    }

    private triggerAfterPreview = () => {
        console.log('triggerAfterPreview');
        this.props.closeFunction();
    }

    render() {

        return (
            <div id="overlay" onClick={this.closeOverlay}>
                {
                    this.state.countdownVisible ? <Countdown counterInSeconds={5} triggerForCapture={this.triggerForCapture} triggerAfterDone={this.triggerAfterCountdown} /> : ''
                }

                {
                    this.state.waitingVisible ? <img src={this.props.endpointConfig.endpointBseURI+'/image/loading'} className="centered fullImg" alt="" />  : ''
                }

                {
                    this.state.previewVisible ? <Preview counterInSeconds={10} pictureURI={this.state.picURI}  triggerAfterDone={this.triggerAfterPreview} /> : ''
                }
            </div>);
    }

}
